package presprint.task.manager.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import presprint.task.manager.backend.entity.Task;
import presprint.task.manager.backend.entity.Tracking;
import presprint.task.manager.backend.form.TaskDTO;
import presprint.task.manager.backend.form.TaskReaderDTO;
import presprint.task.manager.backend.service.DTOReaderHelper;
import presprint.task.manager.backend.service.StatusService;
import presprint.task.manager.backend.service.TaskService;
import presprint.task.manager.backend.service.TrackingService;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
	private StatusService statusService;
	private TaskService taskService;
	private TrackingService trackingService;
	private DTOReaderHelper dtoReaderHelper;
	public TaskController(StatusService statusService, TaskService taskService, TrackingService trackingService, DTOReaderHelper dtoReaderHelper) {
		this.statusService = statusService;
		this.taskService = taskService;
		this.trackingService  =trackingService;
		this.dtoReaderHelper  =dtoReaderHelper;
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
		Tracking tracking = new Tracking();
		tracking.setOperation("CREATED THE TASK");
		tracking.setOperationDate(new Date());
		task.setRegistrationDate(new Date());
		taskService.save(task);
		tracking.setTask(task);
		trackingService.save(tracking);

		return new ResponseEntity<String>("CREATED", HttpStatus.CREATED);
	}

	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody TaskDTO taskDTO){

		Optional<Task> task = taskService.findById(taskDTO.getId());
		if (task.isPresent()) {
			Task task1= task.get();

			task1.setTitle(taskDTO.getTitle());
			task1.setDescription(taskDTO.getDescription());
			task1.setDuration(taskDTO.getDuration());
			taskService.save(task1);
			Tracking tracking = new Tracking();
			tracking.setOperation("UPDATED THE TASK");
			tracking.setOperationDate(new Date());
			tracking.setTask(task1);
			trackingService.save(tracking);

		}else{
			return new ResponseEntity<String>("KO", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>("UPDATED", HttpStatus.CREATED);
	}

	@RequestMapping(value="/readOne", method = RequestMethod.GET)
	public ResponseEntity<TaskReaderDTO> readOne(@RequestParam("id") int id){
		Optional<Task> task = taskService.findById(id);
		if(task.isPresent()) {
		return new ResponseEntity<TaskReaderDTO>(dtoReaderHelper.convert(task.get()), HttpStatus.OK);
		}
		else return new ResponseEntity<TaskReaderDTO>(new TaskReaderDTO(), HttpStatus.NOT_FOUND);
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
