package com.dodo.dodoworld.web;

import com.dodo.dodoworld.domain.Address;
import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.domain.Member;
import com.dodo.dodoworld.repository.SearchCondition;
import com.dodo.dodoworld.service.BoardService;
import com.dodo.dodoworld.service.MemberService;
import com.dodo.dodoworld.web.dto.board.CreateBoardDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/boards")
public class BoardController {
    /**
     * 게시판 컨트롤러
     */

    private final BoardService boardService;
    private final MemberService memberService;

    // 게시판 목록
    @GetMapping()
    public String boards(Model model) {
        List<Board> boards = boardService.findBoards(new SearchCondition());
        // 반환용 dto 사용.
        model.addAttribute("boards", boards);
        return "board/boardList";
    }

    // 게시판 한글 읽기
    @GetMapping("/{id}")
    public String board(Model model, @PathVariable("id") Long boardId) {
        Optional<Board> findBoard = boardService.findOne(boardId);
        // dto 변환 후 보내기
        model.addAttribute("board", findBoard.get());
        return "board/boardOne";
    }

    // 게시글 등록 페이지
    @GetMapping("/save")
    public String boardSavePage(Model model) {
        model.addAttribute("board", new Board("insert title"));
        return "board/boardSave";
    }


    // 게시글 등록
    @PostMapping("/save")
    public String boardSave(@ModelAttribute("board") CreateBoardDto dto) {
        // test용 임시 아이디
        Member member = new Member(dto.getWriter(), "1234", dto.getWriter(), "dodo@gmail.com", LocalDateTime.now(),
                new Address("Seoul", "Gwan-Ak", "MiSung-dong", "123-123"), null);
        memberService.saveMember(member);
        Board board = new Board(member, dto.getBoardCategories(), dto.getTitle(), dto.getContent());
        boardService.save(board);
        return "redirect:/boards";
    }

    // 게시글 수정 페이지
    @GetMapping("/{id}/edit")
    public String boardUpdatePage(Board board) {
        return "board/boardEdit";
    }

    // 게시글 수정
    @PutMapping("/{id}/edit")
    public String boardUpdate(Board board) {
        boardService.update(board);
        return "redirect:/boards";
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public String boardDelete(Board board) {
        boardService.delete(board);
        return "redirect:/boards";
    }
}
