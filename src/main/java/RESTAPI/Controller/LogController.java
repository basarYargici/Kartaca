package RESTAPI.Controller;

import RESTAPI.Business.Abstract.LogService;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 25.03.2021
 * <p>
 * This class is the REST Controller of Log.
 */
@RestController
@RequestMapping("/api")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    /**
     * This method returns all logs.
     *
     * @return List of Log
     */
    @GetMapping("/logs")
    public List<Log> get() {
        return logService.getAll();
    }

    /**
     * This method gets the city by id.
     *
     * @param id is the id of Log
     * @return City whose id is id
     */
    @GetMapping("/logs/{id}")
    public Log getById(@PathVariable int id) {
        return logService.getById(id);
    }

    /**
     * This method gets city body and saves it but there is no need for that. If its needed only add @GetMapping annotation.
     *
     * @param log is the body of new Log
     */
    public void add(Log log) {
        logService.add(log);
    }
}
