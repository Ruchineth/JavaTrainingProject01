package project.EmployeeManagementSystem.operationservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ProjectWithTask.ProjectWithTaskPK.class)
public class ProjectWithTask implements Serializable {
    @Id
    public Integer employeeId;
    @Id
    public Integer projectId;
    @Id
    public Integer taskId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
    static class ProjectWithTaskPK implements Serializable {
        protected Integer employeeId;
        protected Integer projectId;
        protected Integer taskId;

        public ProjectWithTaskPK() {}

        public ProjectWithTaskPK(Integer employeeId, Integer projectId,Integer taskId) {
            this.employeeId = employeeId;
            this.projectId = projectId;
            this.taskId = taskId;
        }
        // equals, hashCode
    }
}
