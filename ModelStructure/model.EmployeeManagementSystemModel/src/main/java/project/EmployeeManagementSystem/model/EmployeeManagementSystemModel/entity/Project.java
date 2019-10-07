package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer prId;
    String prName;
    @OneToMany
    List<Task> task;
}
