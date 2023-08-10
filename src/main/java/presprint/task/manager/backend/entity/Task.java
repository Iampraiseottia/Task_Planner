package presprint.task.manager.backend.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name="task")
public class Task{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name="employee_id", nullable=true)
	@JsonIgnore
	private Employee employee;

	@ManyToOne
	@JoinColumn(name="status_id", nullable=false)
	@JsonIgnore
	private Status status;

	@Column(name="coverage_percentage" ,columnDefinition = " Integer comment 'poucentage de evolution de la tache'")
	private int  coveragePercentage;

	@Column(name="title")
	private String  title;

	@Column(name="description")
	private String description;

	@Column(name="registration_date")
	private Date registrationDate;

	@Column(name="duration" ,columnDefinition = " Integer comment 'duree de la tache'")
	private int  duration;

	@OneToMany(mappedBy="task")
	@JsonIgnore
	private List<Tracking> trackings;
}
