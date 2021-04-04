package RESTAPI.Engine.Controller;

import RESTAPI.Engine.Service.ProducerService;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author İbrahim Başar YARGICI
 * @date 24.03.2021
 * <p>
 * This class is the REST Controller Kafka Log.
 */
@RestController
@EnableAsync
public final class KafkaController {
    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    /**
     * This method gets log body and sends it as a message.
     *
     * @param log is the body of Log
     */
    @PostMapping
    public void sendMessageToKafkaTopic(@RequestParam Log log) {
        producerService.sendMessage(log);
    }
}