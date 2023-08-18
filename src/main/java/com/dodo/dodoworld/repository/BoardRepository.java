package com.dodo.dodoworld.repository;

import com.dodo.dodoworld.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByIsDeletedIsFalse(); // 삭제 되지 않은 모든 글 조회.

    // 페이징
    @Override
    Page<Board> findAll(Pageable pageable);

    // 개추 버튼
    @Query("update Board b set b.likes = (b.likes + 1) where b.id = :boardId")
    void plusLike(@Param("boardId") Long boardId);
}
