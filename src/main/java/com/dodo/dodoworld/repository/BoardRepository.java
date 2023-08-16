package com.dodo.dodoworld.repository;

import com.dodo.dodoworld.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByIsDeletedIsFalse(); // 삭제 되지 않은 모든 글 조회.
}
