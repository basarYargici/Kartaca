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
 */
@RestController
@EnableAsync
public final class KafkaController {
    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public void sendMessageToKafkaTopic(@RequestParam Log log) {
        producerService.sendMessage(log);
    }
}