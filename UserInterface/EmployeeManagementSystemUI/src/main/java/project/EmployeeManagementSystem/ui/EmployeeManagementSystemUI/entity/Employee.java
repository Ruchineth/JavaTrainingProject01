package project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer emId;

    String emFirstName;
    String emLastName;
    String emNo;

    public String getEmNo() {
        return emNo;
    }

    public void setEmNo(String emNo) {
        this.emNo = emNo;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "EmployeeProject", joinColumns = @JoinColumn(name = "emId", referencedColumnName = "emId"), inverseJoinColumns = @JoinColumn(name = "prId", referencedColumnName = "prId"))
    List<Project> project;

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

    public String getEmFirstName() {
        return emFirstName;
    }

    public void setEmFirstName(String emFirstName) {
        this.emFirstName = emFirstName;
    }

    public String getEmLastName() {
        return emLastName;
    }

    public void setEmLastName(String emLastName) {
        this.emLastName = emLastName;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
}
