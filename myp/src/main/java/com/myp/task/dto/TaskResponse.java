package com.myp.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskResponse {

    private long taskId;
    private String taskName;
    private String taskStatus;  // enum 진행중 , 완료, 우선순위
}
