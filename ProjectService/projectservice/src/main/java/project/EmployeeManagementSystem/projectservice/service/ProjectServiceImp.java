package project.EmployeeManagementSystem.projectservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.EmployeeManagementSystem.projectservice.entity.Project;
import project.EmployeeManagementSystem.projectservice.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    public Project save(Project project){
        return projectRepository.save(project);
    }
    public List<Project> getAll(){
        return projectRepository.findAll();
    }
    public Project getProjectById(Integer id){

        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            return project.get();
        } else {
            return null;
        }
    }

}
