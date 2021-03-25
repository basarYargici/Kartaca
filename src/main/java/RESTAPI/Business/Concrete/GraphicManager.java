package RESTAPI.Business.Concrete;

import RESTAPI.DataAccess.Hibernate.Abstract.IGraphicService;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 26.03.2021
 */
@Service
public class GraphicManager {

    private final IGraphicService graphicService;

    @Autowired
    public GraphicManager(IGraphicService graphicService) {
        this.graphicService = graphicService;
    }

    public List<Log> readLogs(File file) {
        return graphicService.readLogs(file);
    }

}
