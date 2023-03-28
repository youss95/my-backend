package com.myp.workspace.service;

import com.myp.workspace.domain.Participant;
import com.myp.workspace.domain.WorkSpace;
import com.myp.workspace.repository.WokrSpaceRepository;
import com.myp.workspace.repository.participant.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkSpaceService {

    private final WokrSpaceRepository wokrSpaceRepository;
    private final ParticipantRepository participantRepository;
    public void getWorkSpace() {
       Optional<Participant> workSpace = participantRepository.findById(1L);
        log.debug("ksy {}",workSpace);
    }
}
