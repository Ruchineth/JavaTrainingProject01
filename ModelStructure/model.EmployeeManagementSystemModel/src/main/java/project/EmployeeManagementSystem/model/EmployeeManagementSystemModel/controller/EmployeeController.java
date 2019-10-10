package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity.Employee;
import project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.service.EmployeeServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceImp employeeServiceImp;

    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    @PreAuthorize(("hasAuthority('create_profile')"))
    public Employee save(@RequestBody Employee employee){

        return employeeServiceImp.save(employee);
    }
    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public List<Employee> getAllEmployee(){
        return employeeServiceImp.getAll();
    }

    @RequestMapping(value = "/employees/{id}",method = RequestMethod.GET)
    @PreAuthorize(("hasAuthority('read_profile')"))
    public Employee getEmployeetById(@PathVariable Integer id){
        return employeeServiceImp.getEmployeetById(id);
    }

}
