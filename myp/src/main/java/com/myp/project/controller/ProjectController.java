package com.myp.project.controller;

import com.myp.project.dto.NewProjectResponse;
import com.myp.project.dto.ProjectCreateRequest;
import com.myp.project.dto.ProjectResponse;
import com.myp.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    // TODO: workspace에서 조회
    @GetMapping("/")
    public ResponseEntity<ProjectResponse> getAllProjects() {

        return null;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable long projectId) {

        return ResponseEntity.ok(projectService.findProjectDetail(projectId));
    }

    @PostMapping("/")
    public ResponseEntity<Void> createProject(@RequestBody ProjectCreateRequest req) {
        NewProjectResponse project = projectService.createNewProject(req);
        return ResponseEntity.created(URI.create("/project/" + project.getProjectId())).build();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Void> updateProject(String projectName, String description, Long projectId) {

        projectService.updateProject(projectName, description, projectId);
        return ResponseEntity.noContent().build();
    }



}
