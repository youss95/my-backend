package com.myp.workspace.dto;

import com.myp.workspace.domain.CoWorker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class CoWorkerRequest {

    private String repYn;

    public CoWorker toParticipant() {
        return CoWorker.builder()
                .repYn("Y")
                .build();
    }
}
