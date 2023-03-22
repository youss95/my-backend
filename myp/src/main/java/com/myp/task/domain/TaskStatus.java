package com.myp.task.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum TaskStatus {

    BACKLOG(0), RUN(1), DONE(-1);

    private static Map<Integer, TaskStatus> valueMap = Arrays.stream(TaskStatus.values())
            .collect(Collectors.toMap(TaskStatus::getValue, Function.identity()));

    private Integer value;

    public static TaskStatus fromValue(final Integer value) {
        if(value == null) throw new IllegalArgumentException("value 없음");
        return valueMap.get(value);
    }

    //생성자 초기화, 모든 상수가 value 같게 하기
    TaskStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
