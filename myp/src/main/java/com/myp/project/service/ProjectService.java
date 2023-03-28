package com.myp.project.service;

import com.myp.project.domain.Project;
import com.myp.project.dto.NewProjectResponse;
import com.myp.project.dto.ProjectCreateRequest;
import com.myp.project.dto.ProjectResponse;
import com.myp.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public NewProjectResponse createNewProject(final ProjectCreateRequest request) {
        Project project = request.toProject();

        Project savedProject = projectRepository.save(project);
        return new NewProjectResponse(savedProject);
    }

    public void updateProject(final String projectName,final String description,final Long projectId) {

        projectRepository.updateProject(projectName, description, projectId);
    }


    public ProjectResponse findProjectDetail(long projectId) {

       final Project project = projectRepository.findById(projectId).orElseThrow();
       return ProjectResponse.of(project);
    }
}
