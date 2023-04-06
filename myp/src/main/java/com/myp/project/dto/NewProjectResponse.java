package com.myp.project.dto;

import com.myp.project.domain.Project;

public class NewProjectResponse {

    private Long projectId;

    public NewProjectResponse(Long projectId) {
        this.projectId = projectId;
    }

    public NewProjectResponse(Project project) {
        this.projectId = project.getId();
    }

    public Long getProjectId() {
        return projectId;
    }
}
