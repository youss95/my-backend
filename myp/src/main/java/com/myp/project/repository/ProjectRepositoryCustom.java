package com.myp.project.repository;

import com.myp.project.dto.ProjectStatusNumber;

public interface ProjectRepositoryCustom {

    //직접 구현한 메소드
    void updateProject(final String projectName, final String description, final Long projectId);

    /**
     *
     * @param workSpaceId
     * @return
     */
    ProjectStatusNumber getCurrentStatusNumber(Long workSpaceId);
}
