package presprint.task.manager.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import presprint.task.manager.backend.entity.Tracking;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Integer> {


}
