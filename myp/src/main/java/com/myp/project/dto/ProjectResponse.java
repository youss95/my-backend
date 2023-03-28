package com.myp.project.dto;

import com.myp.project.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {

    private Long projectId;
    private String description;
    private String projectName;

    public static ProjectResponse of(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getDescription(),
                project.getProjectName()
        );
    }
}
