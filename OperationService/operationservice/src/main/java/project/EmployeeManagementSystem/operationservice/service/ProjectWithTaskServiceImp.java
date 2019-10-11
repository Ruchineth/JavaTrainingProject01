package project.EmployeeManagementSystem.operationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.EmployeeManagementSystem.operationservice.entity.ProjectWithTask;
import project.EmployeeManagementSystem.operationservice.repository.ProjectWithTaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectWithTaskServiceImp implements ProjectWithTaskService {
    @Autowired
    ProjectWithTaskRepository projectWithTaskRepository;
    public ProjectWithTask save(ProjectWithTask projectWithTask){

        return projectWithTaskRepository.save(projectWithTask);
    }
   /* public List<Task> getAll(){
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
*/
}
