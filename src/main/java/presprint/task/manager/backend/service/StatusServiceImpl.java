package presprint.task.manager.backend.service;


import org.springframework.stereotype.Service;
import presprint.task.manager.backend.entity.Status;
import presprint.task.manager.backend.repository.StatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status findByName(String name) {
        return statusRepository.findByName(name);
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<Status> findById(int id) {
        return statusRepository.findById(id);
    }
}
