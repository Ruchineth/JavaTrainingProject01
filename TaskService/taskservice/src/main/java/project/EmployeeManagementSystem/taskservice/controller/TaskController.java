package project.EmployeeManagementSystem.taskservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.EmployeeManagementSystem.taskservice.entity.Task;
import project.EmployeeManagementSystem.taskservice.service.TaskService;
import project.EmployeeManagementSystem.taskservice.service.TaskServiceImp;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskServiceImp taskServiceImp;

    @RequestMapping(value = "/tasks",method = RequestMethod.POST)
    @PreAuthorize(("hasAuthority('create_profile')"))
    public Task save(@RequestBody Task task){

        return taskServiceImp.save(task);
    }
    @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public List<Task> getAllTask(){
        return taskServiceImp.getAll();
    }

    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public Task getTaskById(@PathVariable Integer id){
        return taskServiceImp.getTaskById(id);
    }

}
