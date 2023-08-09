package presprint.task.manager.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
	
	@RequestMapping(value="/test", method =RequestMethod.GET)
	public String sayHello(@RequestParam("message") String message) {
		return "Hello Sir="+message;
	}

}
