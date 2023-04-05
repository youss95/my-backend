package com.myp.service;

import com.myp.member.domain.Member;
import com.myp.member.dto.MemberJoinRequest;
import com.myp.member.repository.MemberRepository;
import com.myp.member.service.MemberService;
import com.myp.workspace.domain.CoWorker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;
    private final MemberJoinRequest req =
            new MemberJoinRequest("test", "poo", "abc1234");

    @Test
    @DisplayName("멤버 조인 테스트")
    void joinTest(){
        memberService.join(req);
        Member member = memberRepository.findById(1L).orElseGet(null);
        System.out.println(member.getPassword());
        Assertions.assertEquals(req.getNickName(), "poo");
    }

    @Test
    @DisplayName("멤버 워크스페이스 테스트")
    @Transactional
    void findAllMemberWorkspaceTest() {
      //  memberService.join(req);
      List<CoWorker> list =  memberRepository.findById(1L).get().getParticipants();
        Assertions.assertEquals(list.get(0).getWorkSpace().getName(), "ksy");
    }
}
