package ProjectManagementSystem.PMS.service.impl;


import ProjectManagementSystem.PMS.entity.ProjectEntity;
import ProjectManagementSystem.PMS.exception.ResourceNotFoundException;
import ProjectManagementSystem.PMS.repo.ProjectEntityRepo;
import ProjectManagementSystem.PMS.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectEntityRepo projectEntityRepo;
    @Override
    public ProjectEntity createProject(ProjectEntity projectEntity) {
        return projectEntityRepo.save(projectEntity);
    }
    @Override
    public List<ProjectEntity> getAllProjects() {
        return projectEntityRepo.findAll();
    }

    @Override
    public ProjectEntity updateProject(ProjectEntity projectEntity, long id) {

        ProjectEntity existingProject = projectEntityRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProjectEntity", "id", id));

        existingProject.setProjectName(projectEntity.getProjectName());
        // Update other fields as needed

        return projectEntityRepo.save(existingProject);
    }

    @Override
    public ProjectEntity findProjectById(long id) {
        Optional<ProjectEntity> project = projectEntityRepo.findById(id);
        //check whether the optional Object contains employer object or Not
        if (project.isPresent()) {
            return project.get();
        } else {
            throw new ResourceNotFoundException("Project", "id", id);
        }
    }

    @Override
    public void deleteProject(long id) {
        //check whether Employee exists on the DB
        projectEntityRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProjectEntity", "id", id));
        projectEntityRepo.deleteById(id);
    }

    @Override
    public List<ProjectEntity> deleteAllProjects(p) {
        for (ProjectEntity projectEntity : projectEntities) {
            projectEntityRepo.delete(projectEntity);

        }


        return projectEntities;
    }

    @Override
    public List<ProjectEntity> saveAllProjects(List<ProjectEntity> projectEntities) {
       return projectEntityRepo.saveAll(projectEntities);
    }
}




