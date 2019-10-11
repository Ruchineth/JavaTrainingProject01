package project.EmployeeManagementSystem.operationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.EmployeeManagementSystem.operationservice.entity.ProjectWithTask;
import project.EmployeeManagementSystem.operationservice.service.ProjectWithTaskService;
import project.EmployeeManagementSystem.operationservice.service.ProjectWithTaskServiceImp;

import java.util.List;


@RestController
public class ProjectWithTaskController {
    @Autowired
    ProjectWithTaskServiceImp projectWithTaskServiceImp;

    @RequestMapping(value = "/projectwithtasks",method = RequestMethod.POST)
    @PreAuthorize(("hasAuthority('create_profile')"))
    public void save(@RequestParam List<ProjectWithTask> projectWithTask){
        System.out.println(projectWithTask);


        //return projectWithTaskServiceImp.save(projectWithTask);
    }
   /* @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public List<Task> getAllTask(){
        return taskServiceImp.getAll();
    }

    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public Task getTaskById(@PathVariable Integer id){
        return taskServiceImp.getTaskById(id);
    }
*/
}
