package com.myp.member.service;



import com.myp.core.security.JwtProvider;
import com.myp.member.domain.Member;
import com.myp.member.domain.NickName;
import com.myp.member.domain.Password;
import com.myp.member.dto.MemberJoinRequest;
import com.myp.member.dto.MemberLoginResponse;
import com.myp.member.repository.MemberRepository;
import com.myp.workspace.domain.CoWorker;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;
    public Boolean checkUniqueLoginId(String loginId) {

        return memberRepository.checkUniqueLoginId(loginId);
    }

    public Boolean checkUniqueNickName(String nickName) {

        return memberRepository.checkUniqueLoginId(nickName);
    }

    public void join(MemberJoinRequest memberJoinRequest) {

        Member member = Member.builder()
                .loginId(memberJoinRequest.getLoginId())
                .password(Password.encode(memberJoinRequest.getPassword(),passwordEncoder))
                .nickName(NickName.of(memberJoinRequest.getNickName()))
                .build();

        memberRepository.save(member);
    }

    public List<CoWorker> findAllMemberWorkspace(long memberId) {

        return memberRepository.findById(memberId).get().getParticipants();
    }

    public MemberLoginResponse login(MemberJoinRequest request) throws Exception  {
        Member member = memberRepository.findByLoginId(request.getLoginId()).orElseThrow(() -> new RuntimeException("login error"));

        if(!passwordEncoder.matches(request.getPassword(),member.getPassword().getPassword())) {
            throw new BadCredentialsException("invalid account");
        }

         return MemberLoginResponse.builder()
                         .id(member.getId())
                                 .loginId(member.getLoginId())
                                         .token(jwtProvider.createToken(member.getLoginId()))
                 .build();
    }
}
