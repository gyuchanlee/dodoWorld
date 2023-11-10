package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Member;
import com.dodo.dodoworld.repository.MemberRepository;
import com.dodo.dodoworld.web.dto.member.CreateMemberDto;
import com.dodo.dodoworld.web.dto.member.UpdateMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void saveMember(CreateMemberDto dto) {
        log.info("member 저장 ={}", dto);
        Member member = new Member(dto.getUserId(), dto.getPassword(), dto.getUsername(),
                dto.getEmail(), dto.getBirth(), dto.getAddress(), null);
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void deleteMember(String userId) {
        log.info("member 삭제 = {}", userId);
        memberRepository.memberDelete(userId);
    }

    @Override
    @Transactional
    public void updateMember(UpdateMemberDto dto) {
        log.info("[미구현] member 수정 = {}", dto);
        // member 엔티티에 멤버 수정 void 메서드 만들기!!
        Member findMember = memberRepository.findByUserIdAndIsDeletedIsFalse(dto.getUserId());
        findMember.memberUpdate(dto.getPassword(), dto.getUsername(), dto.getEmail(), dto.getBirth(), dto.getAddress());
        // 더티 체킹

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
