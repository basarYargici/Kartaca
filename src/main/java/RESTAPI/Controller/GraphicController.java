package RESTAPI.Controller;

import RESTAPI.Business.Abstract.GraphicService;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 28.03.2021
 */
@RestController
@RequestMapping("/api/graph")
public class GraphicController {
    private GraphicService graphicService;

    @GetMapping("/")
    public void graph(List<List<Log>> logs) {
        graphicService.sketchGraph(logs);
    }
}
