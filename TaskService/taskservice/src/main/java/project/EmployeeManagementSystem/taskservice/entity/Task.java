package project.EmployeeManagementSystem.taskservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer taId;
    String taName;
    public Integer getTaId() {
        return taId;
    }

    public void setTaId(Integer taId) {
        this.taId = taId;
    }

    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }


}
