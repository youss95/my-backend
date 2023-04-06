package com.myp.project.dto;

import com.myp.project.domain.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class ProjectCreateRequest {

    @NotEmpty(message = "프로젝트 이름을 입력해주세요.")
    private String projectName;

    private String description;

    public ProjectCreateRequest(final String projectName, final String description) {
        this.projectName = projectName;
        this.description = description;
    }

    public Project toProject() {
        return Project.builder()
                .projectName(projectName)
                .description(description)
                .build();
    }
}
