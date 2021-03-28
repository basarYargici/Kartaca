package RESTAPI.Controller;

import RESTAPI.Business.Abstract.GraphicService;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 28.03.2021
 */
@Controller
@RequestMapping("/api/graph")
public class GraphicController {
    private GraphicService graphicService;

    @Autowired
    public GraphicController(GraphicService graphicService) {
        this.graphicService = graphicService;
    }

    @GetMapping("/")
    public String graph(List<List<Log>> logs) {
        return graphicService.sketchGraph(logs);
    }
}
