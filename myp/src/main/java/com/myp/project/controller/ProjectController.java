package com.myp.project.controller;

import com.myp.project.dto.NewProjectResponse;
import com.myp.project.dto.ProjectCreateRequest;
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

    @GetMapping("/")
    public ResponseEntity<Void> getAllProjects() {

        return null;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Void> getProject(@PathVariable long projectId) {

        return null;
    }

    @PostMapping("/")
    public ResponseEntity<Void> createProject(@RequestBody ProjectCreateRequest req) {
        NewProjectResponse project = projectService.createNewProject(req);
        return ResponseEntity.created(URI.create("/project/" + project.getProjectId())).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateProject() {

        return ResponseEntity.noContent().build();
    }



}
