package radius.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import radius.drone.entity.Tracking;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Integer> {


}
