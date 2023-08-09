package presprint.task.manager.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import presprint.task.manager.backend.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {


}
