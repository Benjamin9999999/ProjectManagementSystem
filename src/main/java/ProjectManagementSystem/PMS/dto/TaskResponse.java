package ProjectManagementSystem.PMS.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TaskResponse {
    private Long id;
    private Long projectId;
    private String taskName;
    private String taskDescription;
    private String startDate;
    private String endDate;

}
