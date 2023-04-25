package com.myp.member.domain;

import com.myp.core.domain.BaseDate;
import com.myp.workspace.domain.CoWorker;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member extends BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;


    @Column(name = "login_id",unique = true)
    private String loginId;

    @Embedded
    private NickName nickName;

    @Embedded
    private Password password;

    @OneToMany(mappedBy = "member")
    private List<CoWorker> participants = new ArrayList<>();

    public Member(String loginId, NickName nickName, Password password) {
        this.loginId = loginId;
        this.nickName = nickName;
        this.password = password;
    }

}
