package RESTAPI.Business.Concrete;

import RESTAPI.Business.Abstract.LogService;
import RESTAPI.DataAccess.Hibernate.Abstract.ILogDao;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 25.03.2021
 * <p>
 * This class will contain business code on ILogDao instance.
 */
@Service
public class LogManager implements LogService {

    private final ILogDao logDao;

    @Autowired
    public LogManager(ILogDao logDao) {
        this.logDao = logDao;
    }

    /**
     * This method gets all logs which ILogDao instance provides.
     *
     * @return list of Log
     */
    @Override
    @Transactional
    public List<Log> getAll() {
        return logDao.getAll();
    }

    /**
     * This method gets the Log whose id is equal to given id.
     *
     * @param id is the id of Log
     * @return Log from database whose id is id
     */
    @Override
    @Transactional
    public Log getById(int id) {
        return logDao.getById(id);
    }

    /**
     * This method saves new Log.
     *
     * @param log is the new Log instance that will be added to database
     */
    @Override
    @Transactional
    public void add(Log log) {
        logDao.add(log);
    }
}
