package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity.Employee;
import project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity.Telephone;
import project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee save(Employee employee){
        for(Telephone tel:employee.getTelephones()){
            tel.setEmployee(employee);
        }

        return employeeRepository.save(employee);
    }
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getStudentById(Integer id){
        return employeeRepository.findById(id);
    }

}
