package ProjectManagementSystem.PMS.service.impl;

import ProjectManagementSystem.PMS.entity.TaskEntity;
import ProjectManagementSystem.PMS.exception.ResourceNotFoundException;
import ProjectManagementSystem.PMS.repo.TaskRepo;
import ProjectManagementSystem.PMS.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Override
    public TaskEntity createTask(TaskEntity taskEntity) {
        return taskRepo.save(taskEntity);
    }

    @Override
    public TaskEntity findTaskById(long id) {
      Optional<TaskEntity>taskEntity1=taskRepo.findById(id);
      if(taskEntity1.isPresent()){
        return taskEntity1.get();
    }else {throw new ResourceNotFoundException("TaskEntity","id",id);
      }
    }

    @Override
    public List<TaskEntity> findAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public TaskEntity updateTask(TaskEntity taskEntity, long id) {
       TaskEntity existingTask= taskRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("TaskEntity","id",id));
       existingTask.setTaskName(taskEntity.getTaskName());
       return taskRepo.save(existingTask);



    }

    @Override
    public void deleteTaskById(long id) {
        taskRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("TaskEntity","id", id));
        taskRepo.deleteById(id);

    }

    @Override
    public List<TaskEntity> deleteAllTasks(List<TaskEntity> taskEntities) {
        for(TaskEntity taskEntity: taskEntities){
            taskRepo.delete(taskEntity);

        }
        return taskEntities;
    }
}
