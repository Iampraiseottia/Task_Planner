package presprint.task.manager.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import presprint.task.manager.backend.entity.Task;
import presprint.task.manager.backend.form.TaskReaderDTO;
import presprint.task.manager.backend.form.TrackingDTO;

@Service
public class DTOReaderHelper {
	
	public TaskReaderDTO convert(Task task) {
		TaskReaderDTO dto =  new TaskReaderDTO();
		dto.setCoveragePercentage(task.getCoveragePercentage());
		dto.setDescription(task.getDescription());
		dto.setDuration(task.getDuration());
		if(task.getEmployee()!=null)
		dto.setEmployee(task.getEmployee().getName());
		dto.setRegistrationDate(task.getRegistrationDate());
		dto.setStatus(task.getStatus().getName());
		dto.setTitle(task.getTitle());
		List<TrackingDTO> trackings =  new ArrayList<TrackingDTO>();
		task.getTrackings().forEach( tracking->{
			TrackingDTO trackingDTO= new TrackingDTO();
		     trackingDTO.setOperation(tracking.getOperation());
		     trackingDTO.setOperationDate(tracking.getOperationDate());
		     trackings.add(trackingDTO);
		});
		dto.setTrackings(trackings);
		return dto;
	}
	
	public List<TaskReaderDTO> convert(List<Task> tasks) {
		List<TaskReaderDTO> dto =  new ArrayList<TaskReaderDTO>();
		tasks.forEach(task->{
			dto.add(this.convert(task));
		});
		return  dto;
	}

}
