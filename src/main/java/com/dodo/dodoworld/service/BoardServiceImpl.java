package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.repository.BoardRepository;
import com.dodo.dodoworld.repository.SearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public void save(Board board) {
        log.info("게시글 저장");
        log.info("board info ={}", board);
        boardRepository.save(board);
        // member <> board 연관관계 편의 메서드
    }

    @Override
    public List<Board> findBoards(SearchCondition searchCondition) {
        log.info("게시글 검색");
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> findOne(Board board) {
        log.info("글 하나 검색");
        return boardRepository.findById(board.getId());
    }

    @Override
    @Transactional
    public void update(Board board) {
        log.info("게시글 수정");
        Board findBoard = boardRepository.findById(board.getId()).get();
        findBoard.updateBoard(board.getBoardCategories(), board.getTitle(), board.getContent());
        // 더티체킹
    }

    @Override
    @Transactional
    public void delete(Board board) {
        log.info("게시글 삭제");
        boardRepository.delete(board);
    }

    @Override
    @Transactional
    public void like(Board board) {
        log.info("게시글 추천");
        boardRepository.plusLike(board.getId());
    }
}
