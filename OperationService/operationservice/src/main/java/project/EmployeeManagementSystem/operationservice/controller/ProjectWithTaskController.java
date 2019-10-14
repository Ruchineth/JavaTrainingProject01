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
    @PreAuthorize("hasAuthority('create_profile')")
    public List<ProjectWithTask> saveAll(@RequestBody List<ProjectWithTask> projectWithTask){



        return projectWithTaskServiceImp.saveAll(projectWithTask);
    }

    @RequestMapping(value = "/projectwithtasks/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read_profile')")
    public List<String> findByEmployeeId(@PathVariable Integer id){
        return projectWithTaskServiceImp.findByEmployeeId(id);
    }


    @RequestMapping(value = "/projectwithtaskwithemployee/{id}/{id1}",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public List<String> findTaskByEmployeeProject(@PathVariable Integer id,@PathVariable String id1){


        Integer employeeId=id;
        String projectName=id1;
        return projectWithTaskServiceImp.findTaskByEmployeeProject(employeeId,projectName);
    }

}
