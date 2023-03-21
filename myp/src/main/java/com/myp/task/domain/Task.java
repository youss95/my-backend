package com.myp.task.domain;

import com.myp.core.domain.BaseDate;

import javax.persistence.*;

@Entity
@Table(name="ya_task")
public class Task extends BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    private String taskName;

}
