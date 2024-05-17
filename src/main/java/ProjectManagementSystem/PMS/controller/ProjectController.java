package ProjectManagementSystem.PMS.controller;

import ProjectManagementSystem.PMS.entity.ProjectEntity;
import ProjectManagementSystem.PMS.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Em-tech/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public ResponseEntity createProject(@RequestBody ProjectEntity projectEntity) {
     projectService.createProject(projectEntity);
//        ProjectResponse projectResponse = convertToResponse(projectEntity);
       return ResponseEntity.status(HttpStatus.CREATED).body(projectEntity);
    }


    @GetMapping("/fetch/all")
    public List<ProjectEntity>getAllProjects(){
       return projectService.getAllProjects();
    }
    @GetMapping("{id}")
    public ResponseEntity<ProjectEntity>getProjectById(@PathVariable("id") long id){
        return new ResponseEntity<ProjectEntity>(projectService.findProjectById(id),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<ProjectEntity>updateProject(@RequestBody ProjectEntity projectEntity, long id){
        return new ResponseEntity<ProjectEntity>(projectService.updateProject(projectEntity, id),HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteProjectById(@PathVariable("id") long id){
        projectService.deleteProject(id);
    return new ResponseEntity<String>("Project deleted successfully", HttpStatus.OK );
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteProjects(List<ProjectEntity> projectEntities){
       projectService.deleteAllProjects(projectEntities);
        String message = "Successfully deleted all registered projects";
      return   ResponseEntity.status(HttpStatus.OK).body(message);

    }

    @PostMapping("/add/all")
    public ResponseEntity<List<ProjectEntity>> saveAllProjects(@RequestBody List<ProjectEntity> projectEntities) {
        List<ProjectEntity> savedProjects = projectService.saveAllProjects(projectEntities); // Assuming projectService has a method saveAllProjects(List<ProjectEntity>)
        return new ResponseEntity<>(savedProjects, HttpStatus.CREATED);
    }
}



//@GetMapping("{id}")
//public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") long id){
//    return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
//
//}
//@PutMapping()
//public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee, Long id){
//
//    return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id
//    ),HttpStatus.OK);
//}
////Build Delete Employee REST API
//@DeleteMapping({"id"})
//public ResponseEntity<String>deleteEmployee(@PathVariable("id") long id){
//
//    return new ResponseEntity<String>("Employee deleted successfully!...", HttpStatus.OK);
//}
//@DeleteMapping("/delete/all")
//List<Employee>deleteAllEmployees(){
//    return employeeService.deleteAllEmployees();
//}
//
//@PostMapping("/add/all")
//public ResponseEntity<List<Employee>> saveEmployees(@RequestBody List<Employee> employees) {
//    List<Employee> savedEmployees = employeeService.saveAllEmployees(employees);
//    return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
//}

