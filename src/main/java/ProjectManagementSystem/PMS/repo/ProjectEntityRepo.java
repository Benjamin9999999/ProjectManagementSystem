package ProjectManagementSystem.PMS.repo;

import ProjectManagementSystem.PMS.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProjectEntityRepo extends JpaRepository<ProjectEntity,Long> {

}
