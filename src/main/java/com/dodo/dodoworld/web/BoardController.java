package com.dodo.dodoworld.web;

import com.dodo.dodoworld.domain.Address;
import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.domain.Member;
import com.dodo.dodoworld.repository.SearchCondition;
import com.dodo.dodoworld.service.BoardService;
import com.dodo.dodoworld.service.MemberService;
import com.dodo.dodoworld.web.dto.board.CreateBoardDto;
import com.dodo.dodoworld.web.dto.board.ResponseBoardDto;
import com.dodo.dodoworld.web.dto.board.UpdateBoardDto;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/boards")
public class BoardController {
    /**
     * 게시판 컨트롤러
     */

    private final BoardService boardService;

    // 게시판 목록
    @GetMapping()
    public String boards(Model model) {
        List<Board> boards = boardService.findBoards(new SearchCondition());
        // 반환용 dto 사용.
        List<ResponseBoardDto> dtos = boards.stream()
                .map(b -> new ResponseBoardDto(b.getWriter().getUserId(), b.getBoardCategories(),
                        b.getContent(), b.getTitle(), b.getLikes()))
                .collect(Collectors.toList());
        model.addAttribute("boards", dtos);
        return "board/boardList";
    }

    // 게시판 한글 읽기
    @GetMapping("/{id}")
    public String board(Model model, @PathVariable("id") Long boardId) {
        Optional<Board> findBoard = boardService.findOne(boardId);
        // dto 변환 후 보내기
        Board board = findBoard.orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다.(BoardController..게시판 한글 읽기Error)"));
        ResponseBoardDto dto = new ResponseBoardDto(board.getWriter().getUserId(), board.getBoardCategories(),
                board.getContent(), board.getTitle(), board.getLikes());
        model.addAttribute("board", dto);
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
    public String boardSave(@ModelAttribute("board") @Valid CreateBoardDto dto) {
        boardService.save(dto);
        return "redirect:/boards";
    }

    // 게시글 수정 페이지
    @GetMapping("/{id}/edit")
    public String boardUpdatePage(Board board) {
        return "board/boardEdit";
    }

    // 게시글 수정
    @PutMapping("/{id}/edit")
    public String boardUpdate(@ModelAttribute("board") @Valid UpdateBoardDto board) {
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
