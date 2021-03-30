package RESTAPI.Business.Concrete;

import RESTAPI.Business.Abstract.GraphicService;
import RESTAPI.DataAccess.Hibernate.Abstract.IGraphicDao;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 26.03.2021
 */
@Service
public class GraphicManager implements GraphicService {

    private final IGraphicDao graphicDao;
    File file = new File("D:/IdeaProjects/KartacaTask/src/main/java/RESTAPI/Log/LogContent.log");


    @Autowired
    public GraphicManager(IGraphicDao graphicDao) {
        this.graphicDao = graphicDao;
    }


    @Override
    public List<List<Log>> readLogs(File file) {
        return graphicDao.readLogs(file);
    }


    @Override
    public String sketchGraph(Model model) {
        List<List<Log>> logs = readLogs(file);
        List<Log> gets = logs.get(0);
        List<Log> posts = logs.get(1);
        List<Log> deletes = logs.get(2);

        Date d = new Date();

        String now = d.getHours() + ":" + d.getMinutes();

        System.out.println("NOOOW" + now);
        model.addAttribute("get", gets);
        model.addAttribute("post", posts);
        model.addAttribute("delete", deletes);
        model.addAttribute("now", now);
        // TODO Now we have list of logs as separated. Next step is sketching Multi Series Area Charts-Graphs
        return "graph.html";
    }

}
