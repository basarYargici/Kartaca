package DataAccess.Hibernate.Concrete;

import DataAccess.Hibernate.Abstract.ICityDao;
import Entity.Concrete.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 20.03.2021
 */

public class HibernateCityDao implements ICityDao {

    private EntityManager entityManager;

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
    public City getById(int id) {
        return null;
    }

    @Override
    public void add(City city) {

    }

    @Override
    public void update(City city) {

    }

    @Override
    public void delete(int id) {

    }
}
