package presprint.task.manager.backend.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskReaderDTO {
	private int id;
	private String status;
	private int coveragePercentage;
	private String title;
	private String description;
	private int duration;
	private Date registrationDate;
	private String employee;
	List<TrackingDTO> trackings= new ArrayList<TrackingDTO>();

}
