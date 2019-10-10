package project.EmployeeManagementSystem.projectservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.EmployeeManagementSystem.projectservice.entity.Project;
import project.EmployeeManagementSystem.projectservice.service.ProjectServiceImp;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectServiceImp projectServiceImp;

    @RequestMapping(value = "/projects",method = RequestMethod.POST)
    @PreAuthorize(("hasAuthority('create_profile')"))
    public Project save(@RequestBody Project project){

        return projectServiceImp.save(project);
    }
    @RequestMapping(value = "/projects",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public List<Project> getAllProject(){
        return projectServiceImp.getAll();
    }

    @RequestMapping(value = "/projects/{id}",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public Project getProjectById(@PathVariable Integer id){
        return projectServiceImp.getProjectById(id);
    }

}
