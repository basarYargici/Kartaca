package RESTAPI.Controller;

import RESTAPI.Business.Abstract.LogService;
import RESTAPI.Entity.Concrete.City;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 25.03.2021
 */
@RestController
@RequestMapping("api/log")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/getLogs")
    public List<Log> get() {
        return logService.getAll();
    }
}
