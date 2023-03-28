package com.myp.workspace.dto;

import com.myp.workspace.domain.Participant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ParticipantRequest {

    private String repYn;

    public Participant toParticipant() {
        return Participant.builder()
                .repYn("Y")
                .build();
    }
}
