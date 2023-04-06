package com.myp.member.controller;

import com.myp.member.dto.MemberJoinRequest;
import com.myp.member.dto.MemberWorkspaceResponse;
import com.myp.member.service.MemberService;
import com.myp.workspace.domain.CoWorker;
import com.myp.workspace.domain.WorkSpace;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/check/id")
    public ResponseEntity<Boolean> checkUniqueLoginId(String loginId) {


        return ResponseEntity.ok(memberService.checkUniqueLoginId(loginId));
    }
    @GetMapping("/check/nickname")
    public ResponseEntity<Boolean> checkUniqueNickName(String nickName) {

        return ResponseEntity.ok(memberService.checkUniqueNickName(nickName));
    }

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody MemberJoinRequest memberJoinRequest) {

        memberService.join(memberJoinRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/workspace")
    public ResponseEntity<List<MemberWorkspaceResponse>> findAllMemberWorkspace(long memberId) {
       List<CoWorker> list = memberService.findAllMemberWorkspace(memberId);
       List<MemberWorkspaceResponse> wkList = list.stream().map(x-> MemberWorkspaceResponse.of(x.getWorkSpace()))
               .collect(Collectors.toList());

       return ResponseEntity.ok(wkList);
    }

}
