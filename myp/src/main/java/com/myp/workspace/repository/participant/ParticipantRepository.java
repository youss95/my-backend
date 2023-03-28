package com.myp.workspace.repository.participant;

import com.myp.workspace.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
