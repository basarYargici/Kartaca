package RESTAPI.DataAccess.Hibernate.Concrete;

import RESTAPI.DataAccess.Hibernate.Abstract.ILogDao;
import RESTAPI.Entity.Concrete.Log;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 25.03.2021
 */
@Repository
public class HibernateLogDao implements ILogDao {

    private final EntityManager entityManager;

    @Autowired
    public HibernateLogDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Log> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("From Log", Log.class).getResultList();
    }

    @Override
    @Transactional
    public Log getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Log.class, id);
    }

    @Override
    @Transactional
    public void add(Log log) {
        Session session = entityManager.unwrap(Session.class);
        session.save(log);
    }
}
