package RESTAPI.Controller;

import RESTAPI.Business.Abstract.CityService;
import RESTAPI.Entity.Concrete.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 20.03.2021
 */
@RequestMapping("/api")
@RestController
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> get() {
        return cityService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody City city) {
        if (city.getCountryCode() == null) return;
        cityService.add(city);
    }

    @PostMapping("/update")
    public void update(@RequestBody City city) {
        if (city.getId() == 0) return;
        cityService.update(city);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody City city) {
        cityService.delete(city);
    }

    @GetMapping("/cities/{id}")
    public City getById(@PathVariable int id) {
        return cityService.getById(id);
    }

    // The @GetMapping("/hello") annotation maps the sayHello() method to GET requests for /hello.
    @GetMapping("/hi")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("hello %s!", name);
    }
}

