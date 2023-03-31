package com.myp.member.controller;

import com.myp.member.dto.MemberJoinRequest;
import com.myp.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
