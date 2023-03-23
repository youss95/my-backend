package com.myp.task.domain;

import com.myp.core.domain.BaseDate;
import com.myp.project.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ya_task")
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    //Project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
    //Note

    //Subtask

}
