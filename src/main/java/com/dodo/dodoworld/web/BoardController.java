package com.dodo.dodoworld.web;

import com.dodo.dodoworld.repository.SearchCondition;
import com.dodo.dodoworld.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String boards(Model model) {
        boardService.findBoards(new SearchCondition());
        model.addAttribute("data", "data");
        return "board/boardList";
    }
}
