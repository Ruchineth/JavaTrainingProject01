package project.EmployeeManagementSystem.operationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.EmployeeManagementSystem.operationservice.entity.ProjectWithTask;

public interface ProjectWithTaskRepository extends JpaRepository<ProjectWithTask,Integer> {

}
