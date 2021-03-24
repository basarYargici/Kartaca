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
 */
@Repository
public class HibernateCityDao implements ICityDao {

    private final EntityManager entityManager;

    @Autowired
    public HibernateCityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM City", City.class).getResultList();
    }

    @Override
    @Transactional
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(City.class, id);
    }

    @Override
    @Transactional
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

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
