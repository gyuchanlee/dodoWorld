package com.dodo.dodoworld.web;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.domain.Member;
import com.dodo.dodoworld.service.MemberService;
import com.dodo.dodoworld.web.dto.member.CreateMemberDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // 회원 리스트 조회
    @GetMapping()
    public String members(Model model) {
        List<Member> members = memberService.findMembers();
        // 반환용 dto 사용하기
        model.addAttribute("members", members);
        return "member/memberList";
    }

    // 회원 가입 페이지
    @GetMapping("/save")
    public String memberSavePage(Model model) {
        return "member/memberSave";
    }

    // 회원 가입
    @PostMapping("/save")
    public String memberSave(@ModelAttribute("member") @Valid CreateMemberDto member) {
        // 회원가입
        memberService.saveMember(member);
        return "redirect:/members";
    }

    // 회원 수정 페이지

    // 회원 수정

    // 회원 삭제
    @DeleteMapping("/{id}")
    public String memberDelete(Member member) {
        memberService.deleteMember(member.getUserId());
        return "redirect:/members";
    }


}
