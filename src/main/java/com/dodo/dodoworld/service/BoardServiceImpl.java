package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.repository.SearchCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Override
    public void save(Board board) {
        log.info("게시글 저장");
    }

    @Override
    public List<Board> findBoards(SearchCondition searchCondition) {
        log.info("게시글 검색");
        return null;
    }

    @Override
    public void update(Board board) {
        log.info("게시글 수정");
    }

    @Override
    public void delete(Board board) {
        log.info("게시글 삭제");
    }
}
