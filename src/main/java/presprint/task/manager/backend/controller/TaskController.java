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
import presprint.task.manager.backend.service.StatusService;
import presprint.task.manager.backend.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
	private StatusService statusService;
	private TaskService taskService;

	public TaskController(StatusService statusService, TaskService taskService) {
		this.statusService = statusService;
		this.taskService = taskService;
	}

	@RequestMapping(value="/test", method =RequestMethod.GET)
	public String sayHello(@RequestParam("message") String message) {
		return "Hello Sir="+message;
	}

	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody TaskDTO taskDTO){

		Task task = new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setDuration(taskDTO.getDuration());
		task.setStatus(statusService.findByName("OPENED"));
		taskService.save(task);

		return new ResponseEntity<String>("UPDATED", HttpStatus.CREATED);
	}

	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody TaskDTO taskDTO){

		Optional<Task> task = taskService.findById(taskDTO.getId());
		if (task.isPresent()) {
			Task task1= task.get();

			task1.setTitle(taskDTO.getTitle());
			task1.setDescription(taskDTO.getDescription());
			task1.setDuration(taskDTO.getDuration());
			task1.setStatus(statusService.findByName("OPENED"));
			taskService.save(task1);
		}else{
			return new ResponseEntity<String>("KO", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>("UPDATED", HttpStatus.CREATED);
	}

	@RequestMapping(value="/readOne", method = RequestMethod.GET)
	public Optional<Task> readOne(@RequestParam("id") int id){
		Optional<Task> task = taskService.findById(id);
		return task;
	}

	@RequestMapping(value="/readAll", method = RequestMethod.GET)
	public List<Task> readAll(@RequestParam("id") int id){
		List<Task> tasks = taskService.findAll();
		return tasks;
	}
/*
	@RequestMapping(value="/readAll", method = RequestMethod.GET)
	public List<Task> readMany(@RequestParam("id") int id){
		List<Task> task = taskService.findMany();
		return task;
	}
*/

}
