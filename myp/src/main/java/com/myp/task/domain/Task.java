package com.myp.task.domain;

import com.myp.core.domain.BaseDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ya_task")
public class Task extends BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    private String taskName;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    @Convert(converter = TaskStatus.class)
    private TaskStatus taskStatus;

    //Project Embedde

    //Note

    //Subtask

}
