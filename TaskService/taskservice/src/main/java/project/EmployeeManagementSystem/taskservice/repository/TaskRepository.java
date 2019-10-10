package project.EmployeeManagementSystem.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.EmployeeManagementSystem.taskservice.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
