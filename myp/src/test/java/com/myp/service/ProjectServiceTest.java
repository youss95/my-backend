package com.myp.service;

import com.myp.project.domain.CategoryType;
import com.myp.project.domain.Project;
import com.myp.project.dto.NewProjectResponse;
import com.myp.project.dto.ProjectCreateRequest;
import com.myp.project.dto.ProjectDetailResponse;
import com.myp.project.repository.ProjectRepository;
import com.myp.project.service.ProjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepository repository;
    private final ProjectCreateRequest req =
            new ProjectCreateRequest("project1", CategoryType.PUBLIC);

    @Test
    @DisplayName("새로운 프로젝트를 생성한다.")
    void createNewProjectTest() {
       NewProjectResponse resp =  projectService.createNewProject(req);
      Project prj = repository.findById(resp.getProjectId()).orElse(null);

        Assertions.assertEquals(req.getProjectName(), prj.getProjectName());

    }
}
