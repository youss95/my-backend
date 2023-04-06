package com.myp.workspace.domain;

import com.myp.core.domain.BaseDate;
import com.myp.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "ya_coworker", uniqueConstraints = {@UniqueConstraint(name = "coworker_unq", columnNames = {"member_id","workspace_id"})})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CoWorker extends BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coworker_id")
    private Long ptId;

    //TODO: 행동 권한으로 변경 고려
    //대표 여부 Y,N
    @NotNull
    private String repYn;

    //USER oneToMany
    @ManyToOne
    @JoinColumn(name =  "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workspace_id")
    private WorkSpace workSpace;

    public CoWorker(String repYn, WorkSpace workSpace) {
        this.repYn = repYn;
        this.workSpace = workSpace;
    }
}
