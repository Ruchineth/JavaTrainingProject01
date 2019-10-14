package project.EmployeeManagementSystem.operationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.EmployeeManagementSystem.operationservice.entity.ProjectWithTask;
import project.EmployeeManagementSystem.operationservice.repository.ProjectWithTaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectWithTaskServiceImp implements ProjectWithTaskService {
    @Autowired
    ProjectWithTaskRepository projectWithTaskRepository;

    public List<ProjectWithTask> saveAll(List<ProjectWithTask> projectWithTask){

        return projectWithTaskRepository.saveAll(projectWithTask);
    }

    @Override
    public List<String> findByEmployeeId(Integer employeeId) {
        List<String> employeeProjects= new ArrayList<>();
        List<ProjectWithTask> projectWithTasks=projectWithTaskRepository.findAll();
        for (ProjectWithTask projectWithTask:projectWithTasks
             ) {
            if (projectWithTask.getEmployeeId()==employeeId){
                employeeProjects.add(projectWithTask.getProjectName());
            }

        }
        return employeeProjects;
    }
    public List<String> findTaskByEmployeeProject(Integer employeeId,String projectName){
        List<String> employeeProjectsTask= new ArrayList<>();
        List<ProjectWithTask> projectWithTasks=projectWithTaskRepository.findAll();
        for (ProjectWithTask projectWithTask:projectWithTasks) {
//            if (projectWithTask.getEmployeeId()==employeeId && projectWithTask.getProjectName()==projectName){
//
//                    employeeProjectsTask.add(projectWithTask.getTaskName());}
            if (projectWithTask.getEmployeeId()==employeeId && projectWithTask.getProjectName().equals(projectName)){

                employeeProjectsTask.add(projectWithTask.getTaskName());}


        }
        return employeeProjectsTask;

    }

}
