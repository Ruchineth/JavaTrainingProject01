package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer taId;
    String taName;
}
