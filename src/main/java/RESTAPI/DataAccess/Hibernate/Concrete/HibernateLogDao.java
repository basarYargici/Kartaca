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
 * <p>
 * This class will access the Log table in database.
 */
@Repository
public class HibernateLogDao implements ILogDao {

    private final EntityManager entityManager;

    @Autowired
    public HibernateLogDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * This method gets all logs from Log table.
     *
     * @return list of Log
     */
    @Override
    @Transactional
    public List<Log> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("From Log", Log.class).getResultList();
    }

    /**
     * This method gets the Log whose id is equal to given id from database.
     *
     * @param id is the id of Log
     * @return Log from database whose id is id
     */
    @Override
    @Transactional
    public Log getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Log.class, id);
    }

    /**
     * This method saves new Log to database.
     *
     * @param log is the new Log instance that will be added to database
     */
    @Override
    @Transactional
    public void add(Log log) {
        Session session = entityManager.unwrap(Session.class);
        session.save(log);
    }
}
