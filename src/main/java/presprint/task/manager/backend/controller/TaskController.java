package presprint.task.manager.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import presprint.task.manager.backend.entity.Task;
import presprint.task.manager.backend.form.TaskDTO;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
	
	@RequestMapping(value="/test", method =RequestMethod.GET)
	public String sayHello(@RequestParam("message") String message) {
		return "Hello Sir="+message;
	}

	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Task create(@RequestBody TaskDTO taskDTO){

		Task task = new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setDuration(taskDTO.getDuration());
		task.setStatus(statusService.findByName("OPENED"));
		taskRepository.save(task);

		return new ResponseEntity<Object>(result, HttpStatus.CREATED);
	}

	@RequestMapping(value="/update", method = RequestMethod.POST)
	public Task update(@RequestBody TaskDTO taskDTO){

		Task task = new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setDuration(taskDTO.getDuration());
		task.setStatus(statusService.findByName("OPENED"));
		taskRepository.save(task);

		return new ResponseEntity<Object>(result, HttpStatus.CREATED);
	}

}
