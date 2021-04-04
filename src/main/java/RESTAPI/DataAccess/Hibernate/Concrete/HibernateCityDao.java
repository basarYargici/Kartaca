package RESTAPI.DataAccess.Hibernate.Concrete;

import RESTAPI.DataAccess.Hibernate.Abstract.ICityDao;
import RESTAPI.Entity.Concrete.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 20.03.2021
 * <p>
 * This class will access the City table in database.
 */
@Repository
public class HibernateCityDao implements ICityDao {

    private final EntityManager entityManager;

    @Autowired
    public HibernateCityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * This method gets all cities from City table.
     *
     * @return List of City
     */
    @Override
    @Transactional
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM City", City.class).getResultList();
    }

    /**
     * This method gets the City whose id is equal to given id from database.
     *
     * @param id is the Id of City
     * @return City from database whose id is id
     */
    @Override
    @Transactional
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(City.class, id);
    }

    /**
     * This method saves new City to database.
     *
     * @param city is the new City instance that will be added to database
     */
    @Override
    @Transactional
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    /**
     * This method first tries to find the city in database. if finds the city, updates it.
     *
     * @param city is a City instance that will be updated in database
     */
    @Override
    @Transactional
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        City updateCity = session.get(City.class, city.getId());

        if (updateCity != null) {
            updateCity = city;
            session.merge(updateCity);
        }
    }

    /**
     * This method first tries to find the city in database. if finds the city, deletes it.
     *
     * @param city is a City instance that will be deleted in database
     */
    @Override
    @Transactional
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        City deleteCity = session.get(City.class, city.getId());

        if (deleteCity != null) {
            session.delete(deleteCity);
        }
    }
}
