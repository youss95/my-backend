package com.myp.workspace.dto;

import com.myp.workspace.domain.CategoryType;
import com.myp.workspace.domain.WorkSpace;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WorkSpaceCreateRequest {

    private String name;

    private CategoryType categoryType;

    public WorkSpaceCreateRequest(String name, CategoryType type) {
        this.name = name;
        this.categoryType = type;
    }

    public WorkSpace toWorkSpace() {
        return WorkSpace.builder()
                .name(name)
                .category(categoryType)
                .build();
    }
}
