package com.myp.project.dto;

import com.myp.project.domain.CategoryType;
import com.myp.project.domain.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class ProjectCreateRequest {

    @NotEmpty(message = "프로젝트 이름을 입력해주세요.")
    private String projectName;

    private CategoryType category;

    public ProjectCreateRequest(final String projectName, final CategoryType category) {
        this.projectName = projectName;
        this.category = category;
    }

    public Project toProject() {
        return Project.builder()
                .projectName(projectName)
                .categoryType(category)
                .build();
    }
}
