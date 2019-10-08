package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer emId;
    String emFirstName;
    String emLastName;
    @OneToOne(cascade = CascadeType.ALL)
    Address address;
    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<Telephone> telephones;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
}
