package project.EmployeeManagementSystem.taskservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.EmployeeManagementSystem.taskservice.entity.Task;
import project.EmployeeManagementSystem.taskservice.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    public Task save(Task task){

        return taskRepository.save(task);
    }
    public List<Task> getAll(){
        return taskRepository.findAll();
    }
    public Task getTaskById(Integer id){

        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            return null;
        }
    }

}
