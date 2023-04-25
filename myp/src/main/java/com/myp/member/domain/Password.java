package com.myp.member.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
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
