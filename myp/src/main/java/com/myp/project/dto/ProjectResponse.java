package com.myp.project.dto;

import com.myp.project.domain.CategoryType;
import com.myp.project.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {

    private Long projectId;
    private CategoryType category;
    private String projectName;

    public static ProjectResponse of(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getCategoryType(),
                project.getProjectName()
        );
    }
}
