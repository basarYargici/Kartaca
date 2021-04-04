package RESTAPI.Business.Concrete;

import RESTAPI.Business.Abstract.GraphicService;
import RESTAPI.DataAccess.Hibernate.Abstract.IGraphicDao;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.File;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 26.03.2021
 * <p>
 * This class will contain business code on IGraphicDao instance.
 */
@Service
public class GraphicManager implements GraphicService {

    private final IGraphicDao graphicDao;

    // .log file
    File file = new File("src/main/java/RESTAPI/Log/LogContent.log");


    @Autowired
    public GraphicManager(IGraphicDao graphicDao) {
        this.graphicDao = graphicDao;
    }

    /**
     * This method reads all logs from given file.
     *
     * @param file is a File instance which will be read
     * @return List of List of Log whose are get, post and delete Logs
     */
    @Override
    public List<List<Log>> readLogs(File file) {
        return graphicDao.readLogs(file);
    }

    /**
     * This method will pass the logs to html page to sketch graph.
     *
     * @param model is the way of of passing attributes
     * @return html page
     */
    @Override
    public String sketchGraph(Model model) {
        List<List<Log>> logs = readLogs(file);
        List<Log> gets = logs.get(0);
        List<Log> posts = logs.get(1);
        List<Log> deletes = logs.get(2);

        model.addAttribute("logs", logs);
        model.addAttribute("get", gets);
        model.addAttribute("post", posts);
        model.addAttribute("delete", deletes);
        // TODO Now we have list of logs as separated. Next step is sketching Multi Series Area Charts-Graphs
        return "graph.html";
    }

}
