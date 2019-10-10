package project.EmployeeManagementSystem.projectservice.service;

import project.EmployeeManagementSystem.projectservice.entity.Project;

import java.util.List;

public interface ProjectService {
    Project save(Project project);
    Project getProjectById(Integer id);
    List<Project> getAll();
}
