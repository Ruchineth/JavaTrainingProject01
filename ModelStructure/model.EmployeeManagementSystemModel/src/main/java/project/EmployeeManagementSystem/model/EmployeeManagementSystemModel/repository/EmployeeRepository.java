package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
