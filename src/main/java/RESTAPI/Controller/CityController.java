package RESTAPI.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author İbrahim Başar YARGICI
 * @date 20.03.2021
 */
@RestController
public class CityController {

    // The @GetMapping("/hello") annotation maps the sayHello() method to GET requests for /hello.
    @GetMapping("/")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("hello %s!", name);
    }

}
