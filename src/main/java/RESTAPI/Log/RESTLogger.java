package RESTAPI.Log;

import RESTAPI.Engine.Controller.KafkaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author İbrahim Başar YARGICI
 * @date 21.03.2021
 */
public class RESTLogger {
    private Logger logger;
    private boolean isLogOpened = false;

    public void openLog() {
        String pathToSaveLog = "D:/IdeaProjects/KartacaTask/src/main/java/RESTAPI/Log/LogContent.log";

        try {
            logger = Logger.getLogger("MyLogger");
            FileHandler fileHandler = new FileHandler(pathToSaveLog, true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
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
        RESTLogger restLogger = new RESTLogger();
        private final KafkaController kafkaController;

        @Autowired
        LoggingInMemory(KafkaController kafkaController) {
            this.kafkaController = kafkaController;
        }

        @Override
        public void add(HttpTrace trace) {
            String method = trace.getRequest().getMethod();
            String status = String.valueOf(trace.getResponse().getStatus());
            String timeTaken = String.valueOf(trace.getTimeTaken());
            String timestamp = String.valueOf(trace.getTimestamp().getEpochSecond());

            String message = method + "," + timeTaken + "," + timestamp;

            restLogger.addLog(message);
            kafkaController.sendMessageToKafkaTopic(message);
//        System.out.printf("%-20s%-20s%-50s%-20s\n", method, status, timeTaken, timestamp);
        }
    }
}
