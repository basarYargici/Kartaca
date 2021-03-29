package RESTAPI.Controller;

import RESTAPI.Business.Abstract.GraphicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author İbrahim Başar YARGICI
 * @date 28.03.2021
 */
@Controller
@RequestMapping("/api")
public class GraphicController {
    private final GraphicService graphicService;


    @Autowired
    public GraphicController(GraphicService graphicService) {
        this.graphicService = graphicService;
    }

    @GetMapping("/graph")
    public String graph(Model model) {
        return graphicService.sketchGraph(model);
    }
}
