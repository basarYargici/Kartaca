package RESTAPI.Controller;

import RESTAPI.Business.Abstract.CityService;
import RESTAPI.Entity.Concrete.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 20.03.2021
 * <p>
 * This class is the REST Controller of City.
 */
@RequestMapping("/api")
@RestController
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * This method returns all cities.
     *
     * @return List of City
     */
    @GetMapping("/cities")
    public List<City> get() {
        return cityService.getAll();
    }

    /**
     * This method gets the city by id.
     *
     * @param id is the id of City
     * @return City whose id is id
     */
    @GetMapping("/cities/{id}")
    public City getById(@PathVariable int id) {
        return cityService.getById(id);
    }

    /**
     * This method gets city body and saves it.
     *
     * @param city is the body of new City
     */
    @PostMapping("/cities/add")
    public void add(@RequestBody City city) {
        // countryCode of City can not be null
        if (city.getCountryCode() == null) return;
        cityService.add(city);
    }

    /**
     * This method gets city and updates it.
     *
     * @param city is the body of City which will be updated
     */
    @PostMapping("/cities/update")
    public void update(@RequestBody City city) {
        // if id is not declared in body, that means id is 0 and id of City can not be 0.
        if (city.getId() == 0) return;
        cityService.update(city);
    }

    /**
     * This method deletes the city.
     *
     * @param city is the body of City which will be deleted
     */
    @DeleteMapping("/cities/delete")
    public void delete(@RequestBody City city) {
        cityService.delete(city);
    }
}

