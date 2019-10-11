package project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectWithTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer prtaId;
    Integer projectId;
    Integer taskId;

    public ProjectWithTask(Integer projectId, Integer taskId) {
        this.projectId = projectId;
        this.taskId = taskId;
    }

    public Integer getPrtaId() {
        return prtaId;
    }

    public void setPrtaId(Integer prtaId) {
        this.prtaId = prtaId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
