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
 */
public class RESTLogger {
    protected final String pathToSaveLog = "D:/IdeaProjects/KartacaTask/src/main/java/RESTAPI/Log/LogContent.log";
    private Logger logger;
    private boolean isLogOpened = false;

    public void openLog() {
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

    // TODO opening log file is not consistent, it can open second log file!
    public void addLog(String message) {
        if (!isLogOpened) {
            openLog();
        }
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

        @Override
        public void add(HttpTrace trace) {
            String method = trace.getRequest().getMethod();
            String status = String.valueOf(trace.getResponse().getStatus());
            String timeTaken = String.valueOf(trace.getTimeTaken());
            String timestamp = String.valueOf(trace.getTimestamp().getEpochSecond());

            String message = String.format("%-10s %-10s %-10s", method, timeTaken, timestamp);

            log.setMethod(method);
            log.setTimeTaken(timeTaken);
            log.setTimestamp(timestamp);

            logService.add(log);
            restLogger.addLog(message);
            kafkaController.sendMessageToKafkaTopic(log);
        }

    }
}
