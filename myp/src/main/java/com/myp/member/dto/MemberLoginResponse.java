package com.myp.member.dto;

import com.myp.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberLoginResponse {

    private Long id;
    private String loginId;
    private String token;

    public MemberLoginResponse(Member member) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
    }
}
