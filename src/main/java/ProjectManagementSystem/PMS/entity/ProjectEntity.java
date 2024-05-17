package ProjectManagementSystem.PMS.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name= "projects")
@Getter
@Setter
@Data


public class ProjectEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getProjectName() {
      return projectName;
   }

   public void setProjectName(String projectName) {
      this.projectName = projectName;
   }

   public String getProjectDescription() {
      return projectDescription;
   }

   public void setProjectDescription(String projectDescription) {
      this.projectDescription = projectDescription;
   }

   public String getStartDate() {
      return startDate;
   }

   public void setStartDate(String startDate) {
      this.startDate = startDate;
   }

   public String getEndDate() {
      return endDate;
   }

   public void setEndDate(String endDate) {
      this.endDate = endDate;
   }

   public List<TaskEntity> getTasks() {
      return tasks;
   }

   public void setTasks(List<TaskEntity> tasks) {
      this.tasks = tasks;
   }

   @Column(name = "Project_name")
   private String projectName;
   private String projectDescription;
   private String startDate;
   private String endDate;
   @OneToMany(mappedBy = "projectEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)// Define one-to-many relationship with TaskEntity
   // Collection of tasks associated with the project
   private List<TaskEntity> tasks; // Collection of tasks associated with the project
//   public long getId() {
//      return id;
//   }
//
//   public void setId(long id) {
//      this.id = id;
//   }
//
//   public String getProjectName() {
//      return projectName;
//   }
//
//   public void setProjectName(String projectName) {
//      this.projectName = projectName;
//   }
//}

}