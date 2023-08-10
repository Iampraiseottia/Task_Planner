package presprint.task.manager.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import presprint.task.manager.backend.entity.Status;
import presprint.task.manager.backend.service.StatusService;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author PRESPRINT PLC August 2023
 * This Code is mainly for the training of trainee
 * for a communication with a  basic backend service through 
 * ajax call
 *
 */
@RestController
@RequestMapping("/api/v1/status")
public class StatusController {

    private StatusService statusService;
    public StatusController(StatusService statusService){
        this.statusService =statusService;
    }

    @RequestMapping(value="/getAllStatus", method = RequestMethod.GET)
    public List<String> getAllStatus() {
        List<Status> allStatuses = statusService.findAll();
        List<String> statuses = new ArrayList<String>();
        for (Status status: allStatuses) {
            statuses.add(status.getName());
        }
        return statuses;
    }
}
