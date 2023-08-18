package com.dodo.dodoworld.web.dto.board;

import com.dodo.dodoworld.domain.BoardCategories;
import com.dodo.dodoworld.domain.Member;

public class CreateBoardDto {

    private String writer; // 작성자 id값
    private BoardCategories boardCategories;

    private String title;
}
