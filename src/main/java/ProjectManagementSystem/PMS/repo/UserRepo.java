package ProjectManagementSystem.PMS.repo;

import ProjectManagementSystem.PMS.entity.ProjectEntity;
import ProjectManagementSystem.PMS.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
