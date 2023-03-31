package com.myp.member.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginId {

    @NotNull
    private String loginId;

    public LoginId(String loginId) {
        this.loginId = loginId;
    }

    public static LoginId of(String loginId) {
        return new LoginId(loginId);
    }
}
