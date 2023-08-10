package presprint.task.manager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presprint.task.manager.backend.entity.Tracking;
import presprint.task.manager.backend.repository.TrackingRepository;

@Service
public class TrackingServiceImpl implements TrackingService {

	@Autowired
	private TrackingRepository trackingRepository;
	@Override
	public void save(Tracking tracking) {
		trackingRepository.save(tracking);
	}

}
