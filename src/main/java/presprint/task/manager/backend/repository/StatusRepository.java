package radius.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import radius.drone.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {


}
