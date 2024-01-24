package com.hks713.jpashop.service;

import com.hks713.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("한경수");

        // when
        Long joinMemberId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(joinMemberId);

        assertThat(findMember.getName()).isEqualTo("한경수");

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member memberA = new Member();
        memberA.setName("hks");
        Member memberB = new Member();
        memberB.setName("hks");

        // when
        memberService.join(memberA);

        // then
        assertThrows(IllegalStateException.class, () -> memberService.join(memberB));
    }

}