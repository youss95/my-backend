package com.myp.project.domain;


import com.myp.core.domain.BaseDate;
import com.myp.task.domain.Task;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ya_project")
public class Project extends BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private String projectName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_category_cd")
    private CategoryType type;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<Task>();
}
