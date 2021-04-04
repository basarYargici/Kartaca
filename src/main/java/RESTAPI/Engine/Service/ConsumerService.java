package RESTAPI.Engine.Service;

import RESTAPI.Entity.Concrete.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author İbrahim Başar YARGICI
 * @date 24.03.2021
 * <p>
 * This class will be be responsible of consumer service.
 */
@Service
public final class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    /**
     * This method consumes the log.
     *
     * @param log is a Log instance
     */
    @KafkaListener(topics = "log_topic", groupId = "group_id")
    public void consume(Log log) {
        logger.info(String.format("$$$$ => Consumed message: %s", log.getMethod()));
    }
}