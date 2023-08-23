package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Member;
import com.dodo.dodoworld.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void saveMember(Member member) {
        log.info("member 저장 ={}", member);
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void deleteMember(Long memberId) {
        log.info("member 삭제 = {}", memberId);
        Member deleteMember = memberRepository.findById(memberId).get();
        memberRepository.delete(deleteMember);
    }

    @Override
    @Transactional
    public void updateMember(Member member) {
        log.info("[미구현] member 수정 = {}", member);
        // member 엔티티에 멤버 수정 void 메서드 만들기!!
    }

    // readOnly codes

    @Override
    public Member findOne(Long memberId) {
        log.info("회원 검색");
        return memberRepository.findById(memberId).isPresent() ? memberRepository.findById(memberId).get() : null;
    }

    @Override
    public List<Member> findMembers() {
        log.info("회원 전체 검색");
        return memberRepository.findAll();
    }
}
