package presprint.task.manager.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tracking")
public class Tracking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="operation")
	private String operation;

	@ManyToOne
	@JoinColumn(name="task_id", nullable=false)
	private Task task;
	

}
