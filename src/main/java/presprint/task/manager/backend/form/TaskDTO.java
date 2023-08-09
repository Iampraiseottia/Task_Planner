package radius.drone.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import radius.drone.entity.Employee;
import radius.drone.entity.Status;

import java.util.Date;

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
