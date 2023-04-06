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
       NewProjectResponse resp =  projectService.createNewProject(req);
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
        projectService.updateProject("update_prj", "description1",1L);
        Project prj = repository.findById(1L).orElse(null);

        Assertions.assertEquals("update_prj", prj.getProjectName());


    }

    @Test
    @DisplayName("최근 7일 프로젝트 테스트")
    void getRecentProjects() {
      List<ProjectResponse> list = projectService.findRecentProjects(1L);
        System.out.println("list"+list.get(0).getProjectName());
    }

    @Test
    @DisplayName("test")
    void test() {
//        WorkSpaceCreateRequest req = new WorkSpaceCreateRequest("ss",CategoryType.PRIVATE);
//        WorkSpace workSpace = req.toWorkSpace();
//        wokrSpaceRepository.save(workSpace);
//        ParticipantRequest req1 = new ParticipantRequest();
//        Participant participant = req1.toParticipant();
//        WorkSpace wk = wokrSpaceRepository.findById(1L).orElseThrow(() -> new RuntimeException());
//        Participant participant1 = new Participant("Y",wk);
//        Participant participant2 = new Participant("Y",wk);
//        participantRepository.save(participant1);
//        participantRepository.save(participant2);
//         Participant pp = participantRepository.findById(1L).orElseThrow(() -> new RuntimeException());
//        System.out.println("ksy: " + pp.getRepYn());
//      //  participantRepository.findAll();
    }
}
