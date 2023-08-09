package presprint.task.manager.backend.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import presprint.task.manager.backend.entity.Employee;
import presprint.task.manager.backend.entity.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

	private Employee employee;
	private Status status;
	private int  coverage_percentage;
	private String  title;
	private String description;
	private Date registration_date;

}
