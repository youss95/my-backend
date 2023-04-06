package com.myp.member.domain;

import com.myp.core.util.PasswordEncoder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

    @Column(name = "password")
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public static Password encode(String password, PasswordEncoder encoder) {
        return new Password(encoder.encode(password));
    }

}
