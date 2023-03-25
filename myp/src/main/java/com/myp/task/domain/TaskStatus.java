package com.myp.task.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum TaskStatus {

    BACKLOG("잔업무"), RUN("진행중"), DONE("완료");

    private static Map<String, TaskStatus> valueMap = Arrays.stream(TaskStatus.values())
            .collect(Collectors.toMap(TaskStatus::getValue, Function.identity()));

    private String value;

    public static TaskStatus fromValue(final String value) {
        if(value == null) throw new IllegalArgumentException("value 없음");
        return valueMap.get(value);
    }

    //생성자 초기화, 모든 상수가 value 같게 하기
    TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
