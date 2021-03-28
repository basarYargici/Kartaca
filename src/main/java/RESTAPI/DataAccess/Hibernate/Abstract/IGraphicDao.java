package RESTAPI.DataAccess.Hibernate.Abstract;

import RESTAPI.Entity.Concrete.Log;

import java.io.File;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 26.03.2021
 */
public interface IGraphicDao {
    List<List<Log>> readLogs(File file);
}
