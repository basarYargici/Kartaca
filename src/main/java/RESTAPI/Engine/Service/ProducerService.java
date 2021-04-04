package RESTAPI.Engine.Service;

import RESTAPI.Entity.Concrete.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author İbrahim Başar YARGICI
 * @date 24.03.2021
 * <p>
 * This class will be responsible of producer service.
 */
@Service
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, Log> kafkaTemplate;
    private final String TOPIC = "log_topic"; // topic name

    @Autowired
    public ProducerService(KafkaTemplate<String, Log> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * This method will send the log instance to kafka.
     *
     * @param log is the instance of Log
     */
    @Async
    public void sendMessage(Log log) {
        logger.info(String.format("$$$$ => Producing message: %s", log.getMethod()));

        ListenableFuture<SendResult<String, Log>> future = this.kafkaTemplate.send(TOPIC, log);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, Log> result) {
                logger.info("Sent message=[ {} ] with offset=[ {} ]", log.getMethod(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.info("Unable to send message=[ {} ] due to : {}", log.getMethod(), ex.getMessage());
            }
        });
    }
}