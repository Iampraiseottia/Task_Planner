package presprint.task.manager.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name="employee_id", nullable=true)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name="status_id", nullable=false)
	private Status status;

	@Column(name="coverage_percentage" ,columnDefinition = " Integer comment 'poucentage de evolution de la tache'")
	private int  coverage_percentage;

	@Column(name="title")
	private String  title;

	@Column(name="description")
	private String description;

	@Column(name="registration_date")
	private Date registration_date;

	@Column(name="duration" ,columnDefinition = " Integer comment 'duree de la tache'")
	private int  duration;

	@OneToMany(mappedBy="task")
	private List<Tracking> trackings;
}
