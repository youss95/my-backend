package com.myp.task.service;

import com.myp.task.domain.Task;
import com.myp.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final static LocalDateTime TODAY_START = LocalDateTime.of(LocalDate.now(), LocalTime.of(0,0,0)); //오늘 00:00:00
    private final static LocalDateTime TODAY_END = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59)); //오늘 24:00:00
    private final TaskRepository taskRepository;


    public void getTask(final long taskId) {


    }

    public List<Task> findAllTodayTasks() {

        List<Task> tasks = taskRepository.findByCreatedDateTimeBetween(TODAY_START, TODAY_END);
        return tasks.isEmpty() ? Collections.emptyList() : new ArrayList<>(tasks);
    }
}
