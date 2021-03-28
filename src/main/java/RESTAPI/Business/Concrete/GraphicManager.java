package RESTAPI.Business.Concrete;

import RESTAPI.Business.Abstract.GraphicService;
import RESTAPI.DataAccess.Hibernate.Abstract.IGraphicDao;
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
public class GraphicManager implements GraphicService {

    private final IGraphicDao graphicDao;

    @Autowired
    public GraphicManager(IGraphicDao graphicDao) {
        this.graphicDao = graphicDao;
    }


    @Override
    public List<List<Log>> readLogs(File file) {
        return graphicDao.readLogs(file);
    }

    @Override
    public void sketchGraph(List<List<Log>> logs) {
        // TODO Now we have list of logs as separated. Next step is sketching Multi Series Area Charts-Graphs
    }

}