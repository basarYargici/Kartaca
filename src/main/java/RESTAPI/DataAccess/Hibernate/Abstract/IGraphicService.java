package RESTAPI.DataAccess.Hibernate.Abstract;

import RESTAPI.Entity.Concrete.Log;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 26.03.2021
 */
public interface IGraphicService {
    List<Log> readLogs(File file);

}
