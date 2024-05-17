package ProjectManagementSystem.PMS.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data@Getter@Setter
public class ProjectRequest {
    private String projectName;
    private String projectDescription;
    private String startDate;
    private String endDate;

}
