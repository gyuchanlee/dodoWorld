package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.repository.SearchCondition;

import java.util.List;

public interface BoardService {

    void save(Board board); // 글 작성

    List<Board> findBoards(SearchCondition searchCondition); // 글 검색

    void update(Board board); // 글 조회

    void delete(Board board); // 글 삭제
}
