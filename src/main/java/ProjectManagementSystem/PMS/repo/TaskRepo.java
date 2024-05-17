package ProjectManagementSystem.PMS.repo;

import ProjectManagementSystem.PMS.entity.ProjectEntity;
import ProjectManagementSystem.PMS.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Long> {
}
