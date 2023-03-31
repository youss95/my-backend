package com.myp.member.service;

import com.myp.core.util.PasswordEncoder;
import com.myp.member.domain.LoginId;
import com.myp.member.domain.Member;
import com.myp.member.domain.NickName;
import com.myp.member.domain.Password;
import com.myp.member.dto.MemberJoinRequest;
import com.myp.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Boolean checkUniqueLoginId(String loginId) {

        return memberRepository.checkUniqueLoginId(loginId);
    }

    public Boolean checkUniqueNickName(String nickName) {

        return memberRepository.checkUniqueLoginId(nickName);
    }

    public void join(MemberJoinRequest memberJoinRequest) {

        Member member = Member.builder()
                .loginId(LoginId.of(memberJoinRequest.getLoginId()))
                .password(Password.encode(memberJoinRequest.getPassword(),passwordEncoder))
                .nickName(NickName.of(memberJoinRequest.getNickName()))
                .build();

        memberRepository.save(member);
    }
}
