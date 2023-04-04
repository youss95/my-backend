package com.myp.project.repository;

import com.myp.project.dto.ProjectResponse;
import com.myp.project.dto.ProjectStatusNumber;

import java.util.List;

public interface ProjectRepositoryCustom {

    //직접 구현한 메소드
    void updateProject(final String projectName, final String description, final Long projectId);

    /**
     *
     * @param workSpaceId
     * @return
     */
    ProjectStatusNumber getCurrentStatusNumber(Long workSpaceId);

    List<ProjectResponse> getRecentProjects(long wkId);
}
