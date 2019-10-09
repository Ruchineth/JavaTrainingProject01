package project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer prId;
    String prName;
    @OneToMany(mappedBy = "project",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<Task> task;

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }
}
