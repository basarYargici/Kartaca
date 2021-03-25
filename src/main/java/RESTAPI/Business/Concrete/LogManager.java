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
 */
@Service
public class LogManager implements LogService {

    private final ILogDao logDao;

    @Autowired
    public LogManager(ILogDao logDao) {
        this.logDao = logDao;
    }


    @Override
    @Transactional
    public List<Log> getAll() {
        return logDao.getAll();
    }

    @Override
    @Transactional
    public Log getById(int id) {
        return logDao.getById(id);
    }

    @Override
    @Transactional
    public void add(Log log) {
        logDao.add(log);
    }
}
