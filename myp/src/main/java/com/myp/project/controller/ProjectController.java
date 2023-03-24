package com.myp.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @GetMapping("/")
    public ResponseEntity<Void> getAllProjects() {

        return null;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Void> getProject(@PathVariable long projectId) {

        return null;
    }

    @PostMapping("/")
    public ResponseEntity<Void> createProject() {

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateProject() {

        return ResponseEntity.noContent().build();
    }



}
