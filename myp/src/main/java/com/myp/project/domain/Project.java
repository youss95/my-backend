package com.myp.project.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myp.core.domain.BaseDate;
import com.myp.task.domain.Task;
import com.myp.workspace.domain.WorkSpace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ya_project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Project extends BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(nullable = false)
    private String projectName;

    private String description;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id")
    private WorkSpace workSpace;

    public int getLeftDays(LocalDateTime startDate, LocalDateTime endDate) {
        return Period.between(startDate.toLocalDate(), endDate.toLocalDate()).getDays();
    }
}
