package RESTAPI.Log;

import RESTAPI.Business.Abstract.LogService;
import RESTAPI.Engine.Controller.KafkaController;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author İbrahim Başar YARGICI
 * @date 21.03.2021
 * <p>
 * This class is responsible for logging processes.
 */
public class RESTLogger {
    protected final String pathToSaveLog = "src/main/java/RESTAPI/Log/LogContent.log";
    private boolean isLogOpened = false; // to check if log file is opened

    private Logger logger;

    /**
     * This method opens the '.log' file if it does not exist.
     */
    public void openLog() {
        if (!isLogOpened) {
            logger = Logger.getLogger("MyLogger");
            try {
                FileHandler fileHandler = new FileHandler(pathToSaveLog, true);
                fileHandler.setFormatter(new SimpleFormatter() {
                    private static final String format = "[%1$tF %1$tT] %3$s %n";

                    @Override
                    public String format(LogRecord record) {
                        return String.format(format,
                                new Date(record.getMillis()),
                                record.getLevel().getLocalizedName(),
                                record.getMessage());
                    }
                });
                logger.addHandler(fileHandler);
                isLogOpened = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * This method takes message and informs the logger file.
     *
     * @param message is the content of log
     */
    public void addLog(String message) {
        openLog();
        // the following statement is used to log any messages
        logger.info(message);
    }

    @Repository
    static class LoggingInMemory extends InMemoryHttpTraceRepository {
        private final KafkaController kafkaController;
        private final Log log;
        private final LogService logService;
        RESTLogger restLogger = new RESTLogger();

        @Autowired
        public LoggingInMemory(KafkaController kafkaController, Log log, LogService logService) {
            this.kafkaController = kafkaController;
            this.log = log;
            this.logService = logService;
        }

        /**
         * If something requested, this method will work and saves the log in .log file, log table in database and will inform the
         * kafka about request via log.
         *
         * @param trace can be used for analyzing contextual information such as HTTP headers
         */
        @Override
        public void add(HttpTrace trace) {
            String method = trace.getRequest().getMethod();
            String status = String.valueOf(trace.getResponse().getStatus());
            String timeTaken = String.valueOf(trace.getTimeTaken());
            String timestamp = String.valueOf(trace.getTimestamp().getEpochSecond());
            Date date = new Date(System.currentTimeMillis());

            String message = String.format("%-10s %-10s %-10s", method, timeTaken, timestamp);

            log.setMethod(method);
            log.setTimeTaken(timeTaken);
            log.setTimestamp(timestamp);
            log.setCreatedTime(date);

            logService.add(log);
            restLogger.addLog(message);
            kafkaController.sendMessageToKafkaTopic(log);
        }

    }
}
