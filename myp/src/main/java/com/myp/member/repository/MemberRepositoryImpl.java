package com.myp.member.repository;

import static com.myp.member.domain.QMember.member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    @Override
    public Boolean checkUniqueLoginId(String loginId) {
        Integer fetchOne = queryFactory
                .selectOne()
                .from(member)
                .where(member.loginId().loginId.eq(loginId))
                .fetchFirst();
        return fetchOne != null;
    }

    @Override
    public Boolean checkUniqueNickName(String nickName) {
       Integer fetchOne = queryFactory
               .selectOne()
               .from(member)
               .where(member.nickName().name.eq(nickName))
               .fetchFirst();
       return fetchOne != null;
    }
}
