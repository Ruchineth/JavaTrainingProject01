package project.EmployeeManagementSystem.operationservice.service;

import project.EmployeeManagementSystem.operationservice.entity.ProjectWithTask;

import java.util.List;


public interface ProjectWithTaskService {
    List<ProjectWithTask> saveAll(List<ProjectWithTask> projectWithTask);
    List<String> findByEmployeeId(Integer employeeId);
    List<String> findTaskByEmployeeProject(Integer employeeId,String projectName);
    /*Project getProjectById(Integer id);
    List<Project> getAll();*/
}
