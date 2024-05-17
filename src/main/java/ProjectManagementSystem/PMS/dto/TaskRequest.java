package ProjectManagementSystem.PMS.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TaskRequest {
    private String taskName;
    private String taskDescription;
    private String startDate;
    private String endDate;

}
