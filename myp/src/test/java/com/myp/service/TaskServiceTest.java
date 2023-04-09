package com.myp.service;

import com.myp.project.domain.Project;
import com.myp.project.dto.NewProjectResponse;
import com.myp.project.dto.ProjectCreateRequest;
import com.myp.project.dto.ProjectResponse;
import com.myp.project.dto.ProjectStatusNumber;
import com.myp.project.repository.ProjectRepository;
import com.myp.project.service.ProjectService;
import com.myp.task.domain.Task;
import com.myp.task.service.TaskService;
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
public class TaskServiceTest {


    @Autowired
    private TaskService taskService;

    @Test
    @DisplayName("today task 조회")
    void findAllTodayTasksTest() {

        List<Task> list =  taskService.findAllTodayTasks();
        System.out.println("kang: " + list.get(0).getCreatedDateTime()  );

    }
}
