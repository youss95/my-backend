package com.myp.member.dto;

import com.myp.workspace.domain.CategoryType;
import com.myp.workspace.domain.WorkSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberWorkspaceResponse {

    private Long wkId;
    private String name;
    private CategoryType category;

    public static MemberWorkspaceResponse of(WorkSpace workSpace) {
        return new MemberWorkspaceResponse(
                workSpace.getWkId(),
        workSpace.getName(),
        workSpace.getCategory()
                );
    }
}
