package com.hks713.jpashop.service;

import com.hks713.jpashop.domain.Member;
import com.hks713.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public Long join(Member member) {
        // 중복회원 검증
        // name 절대로 중복으로 처리 안되어야 한다면 , 데이터 베이스 name 컬럼에
        // unique 제약조건을 걸어서 한번더 방어를 하는게 좋다.
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMember = memberRepository.findByName(member.getName());
        if (!findMember.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 한건 조회
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

}
