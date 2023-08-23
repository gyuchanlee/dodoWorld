package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.domain.Member;
import com.dodo.dodoworld.repository.SearchCondition;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    void saveMember(Member member); // 회원 등록

    Member findOne(Long memberId); // 회원 찾기

    List<Member> findMembers(); // 모든 회원 검색

    void deleteMember(Long memberId); // 회원 삭제

    void updateMember(Member member); // 회원 수정
}
