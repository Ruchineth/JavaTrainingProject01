package project.EmployeeManagementSystem.taskservice.service;

import project.EmployeeManagementSystem.taskservice.entity.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);
    Task getTaskById(Integer id);
    List<Task> getAll();
}
