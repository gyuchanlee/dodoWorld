package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.repository.SearchCondition;
import com.dodo.dodoworld.web.dto.board.CreateBoardDto;
import com.dodo.dodoworld.web.dto.board.UpdateBoardDto;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    // controller -> service 단계에서 dto를 받아 엔티티를 repo로 보내주기.

    void save(CreateBoardDto board); // 글 작성

    List<Board> findBoards(SearchCondition searchCondition); // 글 검색

    Optional<Board> findOne(Long boardId); // 글 하나 검색

    void update(UpdateBoardDto board); // 글 수정

    void delete(Board board); // 글 삭제

    void like(Board board); // 글 추천
}
