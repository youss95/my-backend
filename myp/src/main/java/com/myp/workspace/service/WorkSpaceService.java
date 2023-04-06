package com.myp.workspace.service;


import com.myp.workspace.domain.CoWorker;
import com.myp.workspace.repository.WokrSpaceRepository;
import com.myp.workspace.repository.coWorker.CoWorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkSpaceService {

    private final WokrSpaceRepository wokrSpaceRepository;
    private final CoWorkerRepository coWorkerRepository;
    public void getWorkSpace() {
       Optional<CoWorker> workSpace = coWorkerRepository.findById(1L);
        log.debug("ksy {}",workSpace);
    }
}
