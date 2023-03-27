package com.myp.project.repository;

import com.myp.project.domain.CategoryType;

public interface ProjectRepositoryCustom {

    //직접 구현한 메소드
    void updateProject(final String projectName, final CategoryType category, final Long projectId);
}
