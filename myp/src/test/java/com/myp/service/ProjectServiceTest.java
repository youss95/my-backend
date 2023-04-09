package com.myp.service;

import com.myp.project.domain.Project;
import com.myp.project.dto.NewProjectResponse;
import com.myp.project.dto.ProjectCreateRequest;
import com.myp.project.dto.ProjectResponse;
import com.myp.project.dto.ProjectStatusNumber;
import com.myp.project.repository.ProjectRepository;
import com.myp.project.service.ProjectService;
import com.myp.workspace.repository.WokrSpaceRepository;
import com.myp.workspace.repository.coWorker.CoWorkerRepository;
import com.myp.workspace.service.WorkSpaceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Slf4j
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepository repository;
    @Autowired
    private WokrSpaceRepository wokrSpaceRepository;
    @Autowired
    private CoWorkerRepository participantRepository;
    @Autowired
    private WorkSpaceService workSpaceService;
    private final ProjectCreateRequest req =
            new ProjectCreateRequest("project1", "desc");

    @Test
    @DisplayName("새로운 프로젝트를 생성한다.")
    void createNewProjectTest() {
        NewProjectResponse resp = projectService.createNewProject(req);
        Project prj = repository.findById(resp.getProjectId()).orElse(null);

        Assertions.assertEquals(req.getProjectName(), prj.getProjectName());

    }

    @Test
    @DisplayName("프로젝트 진행 상황 count 조회한다.")
    void getStatusNumber() {
        ProjectStatusNumber nu = repository.getCurrentStatusNumber(1L);
        Assertions.assertEquals(0L, nu.getInquiry());
    }

    @Test
    @DisplayName("프로젝트 내용을 변경한다.")
    void updateProjectTest() {
        projectService.createNewProject(req);
        projectService.updateProject("update_prj", "description1", 1L);
        Project prj = repository.findById(1L).orElse(null);

        Assertions.assertEquals("update_prj", prj.getProjectName());


    }

    private static final LocalDateTime TODAY_START_DAY = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0)); //오늘 00:00:00
    private static final LocalDateTime AFTER_7DAYS = LocalDateTime.of(LocalDate.now().plusDays(7), LocalTime.of(23, 59, 59));

    @Test
    @DisplayName("최근 7일 프로젝트 테스트")
    void getRecentProjects() {
        List<ProjectResponse> list = projectService.findRecentProjects(1L, TODAY_START_DAY, AFTER_7DAYS);
        System.out.println("list" + list.get(0).getProjectName());
        System.out.println("left" + list.get(0).getLeftDays());
    }

    @Test
    @DisplayName(("프로젝트 조회"))
    void findAllProjects() {
        List<ProjectResponse> list = projectService.findAllprojects(1L);
        System.out.println("list" + list.get(0).getProjectStatus()); //COMPLETE
        System.out.println("left" + list.get(0).getLeftDays()); //2
    }
}


