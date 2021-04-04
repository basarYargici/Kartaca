package RESTAPI.Business.Concrete;

import RESTAPI.Business.Abstract.CityService;
import RESTAPI.DataAccess.Hibernate.Abstract.ICityDao;
import RESTAPI.Entity.Concrete.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 20.03.2021
 * <p>
 * This class will contain business code on ICityDao instance.
 */

@Service
public class CityManager implements CityService {

    private final ICityDao cityDao;

    @Autowired
    public CityManager(ICityDao cityDao) {
        this.cityDao = cityDao;
    }

    /**
     * This method gets all cities which cityDao instance provides.
     *
     * @return List of City
     */
    @Override
    @Transactional
    public List<City> getAll() {
        // RESTAPI.Business Code
        return cityDao.getAll();
    }

    /**
     * This method gets the City whose id is equal to given id.
     *
     * @param id is the Id of City
     * @return City from database whose id is id
     */
    @Override
    @Transactional
    public City getById(int id) {
        // RESTAPI.Business Code
        return cityDao.getById(id);
    }

    /**
     * This method saves new City.
     *
     * @param city is the new City instance that will be added to database
     */
    @Override
    @Transactional
    public void add(City city) {
        // RESTAPI.Business Code
        cityDao.add(city);
    }

    /**
     * This method updates the city.
     *
     * @param city is a City instance that will be updated in database
     */
    @Override
    @Transactional
    public void update(City city) {
        // RESTAPI.Business Code
        cityDao.update(city);
    }

    /**
     * This method deletes the city.
     *
     * @param city is a City instance that will be deleted in database
     */
    @Override
    @Transactional
    public void delete(City city) {
        cityDao.delete(city);
    }
}
