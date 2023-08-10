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

	private int id;
	private String  title;
	private String description;
	private int duration;

}
