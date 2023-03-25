package com.myp.project.domain;


import com.myp.core.domain.BaseDate;
import com.myp.task.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    /**
     * 접근 권한
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "project_category_cd")
    private CategoryType categoryType;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();


}
