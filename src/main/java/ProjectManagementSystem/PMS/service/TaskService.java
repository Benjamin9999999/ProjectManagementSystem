package ProjectManagementSystem.PMS.service;

import ProjectManagementSystem.PMS.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    TaskEntity createTask(TaskEntity taskEntity);
    TaskEntity findTaskById(long id);
    List<TaskEntity> findAllTasks();
    TaskEntity updateTask(TaskEntity taskEntity, long id);
   void deleteTaskById(long id);
   List<TaskEntity>deleteAllTasks(List<TaskEntity>taskEntities);


}
