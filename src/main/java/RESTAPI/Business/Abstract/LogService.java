package RESTAPI.Business.Abstract;

import RESTAPI.Entity.Concrete.Log;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 25.03.2021
 */

public interface LogService {
    List<Log> getAll();
    Log getById(int id);
    void add(Log log);
}
