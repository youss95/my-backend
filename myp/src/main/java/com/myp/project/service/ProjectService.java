package com.myp.project.service;

import com.myp.project.domain.Project;
import com.myp.project.dto.NewProjectResponse;
import com.myp.project.dto.ProjectCreateRequest;
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
}
