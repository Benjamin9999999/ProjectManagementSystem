package ProjectManagementSystem.PMS.controller;

import ProjectManagementSystem.PMS.entity.ProjectEntity;
import ProjectManagementSystem.PMS.entity.TaskEntity;
import ProjectManagementSystem.PMS.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Em-tech/api/tasks")

public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity createProject(@RequestBody TaskEntity taskEntity, @RequestParam ProjectEntity projectEntity) {
      taskService.createTask(taskEntity);
//        ProjectResponse projectResponse = convertToResponse(projectEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskEntity);
    }


    @GetMapping("/fetch/all")
    public List<TaskEntity> getAllProjects(){
        return taskService.findAllTasks();
    }
    @GetMapping("{id}")
    public ResponseEntity<TaskEntity>getTaskById(@PathVariable("id") long id){
        return new ResponseEntity<TaskEntity>(taskService.findTaskById(id),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<TaskEntity>updateProject(@RequestBody TaskEntity taskEntity, long id){
        return new ResponseEntity<TaskEntity>(taskService.updateTask(taskEntity, id), HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteProjectById(@PathVariable("id") long id){
        taskService.deleteTaskById(id);
        return new ResponseEntity<String>("Project deleted successfully", HttpStatus.OK );
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteProjects(List<TaskEntity> taskEntities){
       taskService.deleteAllTasks(taskEntities);
        String message = "Successfully deleted all registered projects";
        return   ResponseEntity.status(HttpStatus.OK).body(message);

    }

//    @PostMapping("/add/all")
//    public ResponseEntity<List<TaskEntity>> saveAllProjects(@RequestBody List<TaskEntity> taskEntities) {
//        List<TaskEntity> savedTasks = taskService.sa(projectEntities); // Assuming projectService has a method saveAllProjects(List<ProjectEntity>)
//        return new ResponseEntity<>(savedProjects, HttpStatus.CREATED);
//    }
}


