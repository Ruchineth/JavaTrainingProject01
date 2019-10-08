package project.EmployeeManagementSystem.model.EmployeeManagementSystemModel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer teId;
    String telephoneNo;
    @ManyToOne(cascade = CascadeType.ALL)@JoinColumn @JsonIgnore
    Employee employee;

    public Integer getTeId() {
        return teId;
    }

    public void setTeId(Integer teId) {
        this.teId = teId;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

