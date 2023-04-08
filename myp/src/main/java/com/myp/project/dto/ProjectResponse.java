package com.myp.project.dto;

import com.myp.project.domain.Project;
import com.myp.project.domain.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ProjectResponse {

    private Long projectId;
    private String description;
    private String projectName;

    private ProjectStatus projectStatus;

    private int leftDays;

    public ProjectResponse(Long projectId, String description, String projectName) {
        this.projectId = projectId;
        this.description = description;
        this.projectName = projectName;
    }

    public ProjectResponse(Long projectId, String description, String projectName, ProjectStatus projectStatus, int leftDays) {
        this.projectId = projectId;
        this.description = description;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.leftDays = leftDays;
    }



    public static ProjectResponse of(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getDescription(),
                project.getProjectName(),
                project.getProjectStatus(),
                project.getLeftDays(project.getStartDate(),project.getEndDate())
        );
    }
}
