package com.dodo.dodoworld.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "boardCategories", "title", "content", "likes", "isDeleted"})
public class Board extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boards")
    private Member writer;

    private BoardCategories boardCategories;

    private String title;

    private int likes = 0;

    private Boolean isDeleted = false;

    public Board(Member writer, BoardCategories boardCategories, String title, String content) {
        this.writer = writer;
        this.boardCategories = boardCategories;
        this.title = title;
        this.content = content;
    }

    @Lob
    @Column(columnDefinition = "CLOB")
    private String content;

    // 글 업데이트
    public void updateBoard(BoardCategories boardCategories, String title, String content) {
        this.boardCategories = boardCategories;
        this.title = title;
        this.content = content;
    }


}
