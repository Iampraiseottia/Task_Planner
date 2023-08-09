package presprint.task.manager.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import presprint.task.manager.backend.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	

}
