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
 */
@Service
public class CityManager implements CityService {

    private ICityDao cityDao;

    @Autowired
    public CityManager(ICityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    @Transactional
    public List<City> getAll() {
        // RESTAPI.Business Code
        return cityDao.getAll();
    }

    @Override
    @Transactional
    public City getById(int id) {
        // RESTAPI.Business Code
        return cityDao.getById(id);
    }

    @Override
    @Transactional
    public void add(City city) {
        // RESTAPI.Business Code
        cityDao.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        // RESTAPI.Business Code
        cityDao.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        cityDao.delete(city);
    }
}
