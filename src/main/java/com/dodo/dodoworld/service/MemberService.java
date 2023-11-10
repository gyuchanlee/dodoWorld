package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.domain.Member;
import com.dodo.dodoworld.repository.SearchCondition;
import com.dodo.dodoworld.web.dto.member.CreateMemberDto;
import com.dodo.dodoworld.web.dto.member.UpdateMemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    void saveMember(CreateMemberDto member); // 회원 등록

    Member findOne(Long memberId); // 회원 찾기

    List<Member> findMembers(); // 모든 회원 검색

    void deleteMember(String userId); // 회원 삭제

    void updateMember(UpdateMemberDto member); // 회원 수정

    // ** 이메일 중복, 아이디 중복 체크 로직 만들기.
}
