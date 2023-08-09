package radius.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import radius.drone.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	

}
