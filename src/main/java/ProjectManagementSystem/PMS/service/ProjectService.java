package ProjectManagementSystem.PMS.service;


import ProjectManagementSystem.PMS.entity.ProjectEntity;

import java.util.List;


public interface ProjectService {
    ProjectEntity createProject(ProjectEntity projectEntity);
    List<ProjectEntity>getAllProjects();
    ProjectEntity updateProject(ProjectEntity projectEntity, long id);
    ProjectEntity findProjectById(long id);
    void deleteProject(long id);
    List<ProjectEntity> deleteAllProjects(List<ProjectEntity> projectEntities);
    List<ProjectEntity> saveAllProjects(List<ProjectEntity>projectEntities);



}
