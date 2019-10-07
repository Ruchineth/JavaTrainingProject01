package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer emId;
    String emFirstName;
    String emLastName;

}
