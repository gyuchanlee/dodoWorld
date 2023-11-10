package com.dodo.dodoworld.service;

import com.dodo.dodoworld.domain.Board;
import com.dodo.dodoworld.domain.Member;
import com.dodo.dodoworld.repository.BoardRepository;
import com.dodo.dodoworld.repository.MemberRepository;
import com.dodo.dodoworld.repository.SearchCondition;
import com.dodo.dodoworld.web.dto.board.CreateBoardDto;
import com.dodo.dodoworld.web.dto.board.UpdateBoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    /**
     * - 컨트롤러단에서 Dto를 받아와 repo의 기능을 이용해 서비스 기능 구현
     */

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void save(CreateBoardDto dto) {
        log.info("게시글 저장");
        // dto에 글쓴이 member 오브젝트 검색
        Member writer = memberRepository.findByUserIdAndIsDeletedIsFalse(dto.getWriter());
        // 새로운 게시글 오브젝트 생성
        Board board = new Board(writer, dto.getBoardCategories(), dto.getTitle(), dto.getContent());
        log.info("board info ={}", dto);
        boardRepository.save(board);
        // member <> board 연관관계 편의 메서드
    }

    @Override
    public List<Board> findBoards(SearchCondition searchCondition) {
        log.info("게시글 검색");
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> findOne(Long boardId) {
        log.info("글 하나 검색");
        return boardRepository.findById(boardId);
    }

    @Override
    @Transactional
    public void update(UpdateBoardDto dto) {
        log.info("게시글 수정");
        // 수정할 원 게시글 가져오기
        Board findBoard = boardRepository.findById(dto.getId()).orElseThrow(() -> new NoSuchElementException("Board Update Ex, 해당 글이 없음!!"));
        findBoard.updateBoard(dto.getBoardCategories(), dto.getTitle(), dto.getContent());
        // 더티체킹
    }

    @Override
    @Transactional
    public void delete(Board board) {
        log.info("게시글 삭제");
        boardRepository.boardDelete(board.getId());
    }

    @Override
    @Transactional
    public void like(Board board) {
        log.info("게시글 추천");
        boardRepository.plusLike(board.getId());
    }
}
