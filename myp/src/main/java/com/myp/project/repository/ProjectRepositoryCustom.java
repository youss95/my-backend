package com.myp.project.repository;

public interface ProjectRepositoryCustom {

    //직접 구현한 메소드
    void updateProject(final String projectName, final String description, final Long projectId);
}
