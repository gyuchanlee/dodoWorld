package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.repository.BoardRepository;
import com.dodo.dodoworld.repository.SearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void save(Board board) {
        log.info("게시글 저장");
        log.info("board info ={}", board);
    }

    @Override
    public List<Board> findBoards(SearchCondition searchCondition) {
        log.info("게시글 검색");
        return null;
    }

    @Override
    public Optional<Board> findOne(Board board) {
        log.info("글 하나 검색");
        return boardRepository.findById(board.getId());
    }

    @Override
    public void update(Board board) {
        log.info("게시글 수정");
    }

    @Override
    public void delete(Board board) {
        log.info("게시글 삭제");
    }

    @Override
    public void like(Board board) {
        log.info("게시글 추천");
        boardRepository.plusLike(board.getId());
    }
}
