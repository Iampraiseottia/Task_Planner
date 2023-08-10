package presprint.task.manager.backend.service;

import presprint.task.manager.backend.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {


    public void save(Task task);
    Optional<Task> findById(int id);

    List<Task> findAll();
}
