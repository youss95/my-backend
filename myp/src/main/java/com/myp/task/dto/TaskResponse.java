package com.myp.task.dto;

import com.myp.task.domain.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
public class TaskResponse {

    private Long taskId;
    private String taskName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String taskStatus;

    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;

    public TaskResponse(Long taskId,
                        String taskName,
                        LocalDateTime startDate,
                        LocalDateTime endDate,
                        TaskStatus taskStatus,
                        LocalDateTime created,
                        LocalDateTime updated) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskStatus = taskStatus.getValue();
        this.createdDateTime = created;
        this.updatedDateTime = updated;
    }

}
