package com.myp.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NickName {
    //TODO: validate nickname
    @Column(name = "nickname", unique = true)
    private String name;

    public NickName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return this.name;
    }

    public static NickName of(String nickName) {
        return new NickName(nickName);
    }
}
