package com.myp.workspace.domain;

import com.myp.core.domain.BaseDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ya_participant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Participant extends BaseDate {
    //TODO: userId, workspaceId에 대한 유니크 조건
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long ptId;

    //대표 여부 Y,N
    @NotNull
    private String repYn;

    //USER oneToMany

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workspace_id")
    private WorkSpace workSpace;

    public Participant(String repYn, WorkSpace workSpace) {
        this.repYn = repYn;
        this.workSpace = workSpace;
    }
}
