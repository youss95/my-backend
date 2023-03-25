package com.myp.project.dto;

import com.myp.project.domain.CategoryType;
import lombok.Getter;

@Getter
public class ProjectResponse {

    private String projectId;
    private CategoryType category;
    private String projectName;

}
