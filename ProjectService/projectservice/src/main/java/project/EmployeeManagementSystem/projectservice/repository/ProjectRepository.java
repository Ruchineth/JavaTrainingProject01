package project.EmployeeManagementSystem.projectservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.EmployeeManagementSystem.projectservice.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
