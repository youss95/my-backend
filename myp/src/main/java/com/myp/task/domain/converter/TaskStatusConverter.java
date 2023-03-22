package com.myp.task.domain.converter;

import com.myp.task.domain.TaskStatus;

import javax.persistence.AttributeConverter;
import java.util.Objects;
import java.util.Optional;

public class TaskStatusConverter implements AttributeConverter<TaskStatus, Integer> {

    // entity -> db
    @Override
    public Integer convertToDatabaseColumn(TaskStatus taskStatus) {
        if(Objects.isNull(taskStatus)) {
            return null;
        }

        return taskStatus.getValue();
    }

    @Override
    public TaskStatus convertToEntityAttribute(Integer value) {

        if(Objects.isNull(value)) {
            return null;
        }

        return TaskStatus.fromValue(value);
    }
}
