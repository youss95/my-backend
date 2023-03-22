package com.myp.task.controller;

import com.myp.task.domain.TaskStatus;
import com.myp.task.dto.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    // 작업 단건 상세 조회
    @GetMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse getTask(@PathVariable long taskId) {
        
        return null;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponse> getTaskList() {

        return null;
    }
}
