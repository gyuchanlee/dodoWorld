package com.dodo.dodoworld.web;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.repository.SearchCondition;
import com.dodo.dodoworld.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    /**
     * 게시판 컨트롤러
     */

    private final BoardService boardService;

    // 게시판 목록
    @GetMapping("/boards")
    public String boards(Model model) {
        List<Board> boards = boardService.findBoards(new SearchCondition());
        // 반환용 dto 사용.
        model.addAttribute("data", "data");
        return "board/boardList";
    }

    // 게시판 한글 읽기
    @GetMapping("/boards/{id}")
    public String board(Model model, Board board) {
        Optional<Board> findBoard = boardService.findOne(board);
        // dto 변환 후 보내기
        model.addAttribute("board", findBoard);
        return "board/boardOne";
    }

    // 게시글 등록 페이지
    @GetMapping("/boards/save")
    public String boardSavePage(Board board) {
        return "board/boardEdit";
    }


    // 게시글 등록
    @PostMapping("/boards/save")
    public String boardSave(Board board) {
        boardService.save(board);
        return "redirect:board/boardList";
    }

    // 게시글 수정 페이지
    @GetMapping("/boards/{id}/edit")
    public String boardUpdatePage(Board board) {
        return "board/boardEdit";
    }

    // 게시글 수정
    @PutMapping("/boards/{id}/edit")
    public String boardUpdate(Board board) {
        boardService.update(board);
        return "redirect:/boards";
    }

    // 게시글 삭제
    @DeleteMapping("/boards/{id}")
    public String boardDelete(Board board) {
        boardService.delete(board);
        return "redirect:/boards";
    }
}
