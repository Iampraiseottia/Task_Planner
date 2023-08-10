package presprint.task.manager.backend.service;

import presprint.task.manager.backend.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    public Status findByName(String name);
    public List<Status> findAll();
    public Optional<Status> findById(int id);


}
