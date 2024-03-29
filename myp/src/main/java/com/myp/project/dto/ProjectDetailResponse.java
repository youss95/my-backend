package com.myp.project.dto;

import com.myp.task.dto.TaskResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProjectDetailResponse {

    private Long id;
    private String projectName;
    private String description;
    private List<TaskResponse> tasks;

}
