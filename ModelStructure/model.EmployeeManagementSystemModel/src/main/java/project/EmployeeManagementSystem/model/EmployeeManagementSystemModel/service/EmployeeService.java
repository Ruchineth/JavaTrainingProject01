package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.service;

import project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee getEmployeetById(Integer id);
    List<Employee> getAll();
}
