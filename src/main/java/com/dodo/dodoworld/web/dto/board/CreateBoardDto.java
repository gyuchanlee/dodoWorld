package com.dodo.dodoworld.web.dto.board;

import com.dodo.dodoworld.domain.BoardCategories;
import com.dodo.dodoworld.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateBoardDto {

    private String writer; // 작성자 id값
    private BoardCategories boardCategories;
    private String content;
    private String title;
}
