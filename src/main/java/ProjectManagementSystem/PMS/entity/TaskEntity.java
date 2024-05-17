package ProjectManagementSystem.PMS.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "task_name")
@Getter
@Setter
@Data

public class TaskEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "task_Description")
        private String taskDescription;
        @Column(name = "start_Date")
        private String startDate;
        @Column(name = "end_Date")
        private String endDate;
        @Column(name = "Task_name")
        private String TaskName;
        @ManyToOne(fetch = FetchType.LAZY)// Define many-to-one relationship with ProjectEntity
        @JoinColumn(name = "projectEntity")// Specify the foreign key column
    private ProjectEntity projectEntity;// Reference to the project associated with this task

}
