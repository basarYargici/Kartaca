package Business.Concrete;

import Business.Abstract.CityService;
import DataAccess.Hibernate.Abstract.ICityDao;
import Entity.Concrete.City;
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
        // Business Code
        return cityDao.getAll();
    }

    @Override
    @Transactional
    public City getById(int id) {
        // Business Code
        return cityDao.getById(id);
    }

    @Override
    @Transactional
    public void add(City city) {
        // Business Code
        cityDao.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        // Business Code
        cityDao.update(city);
    }

    @Override
    @Transactional
    public void delete(int id) {
        // Business Code
        cityDao.delete(id);
    }
}
