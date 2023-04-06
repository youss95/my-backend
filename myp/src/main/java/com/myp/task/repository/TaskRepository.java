package com.myp.task.repository;

import com.myp.task.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCreatedDateTimeBetween(LocalDateTime stDate, LocalDateTime endDate);
}
