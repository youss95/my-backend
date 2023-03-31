package com.myp.member.repository;

public interface MemberRepositoryCustom {

    Boolean checkUniqueLoginId(String loginId);

    Boolean checkUniqueNickName(String nickName);
}
