package com.dodo.dodoworld.web.dto.board;

import com.dodo.dodoworld.domain.BoardCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateBoardDto {
    /**
     * 글 수정 Dto
     * 수정목록 : 카테고리, 글 제목, 글 내용.
     * - 검증요소 : 작성자, 카테고리, 글제목
     */

    @NotBlank
    private String writer; // 작성자 id값
    @NotBlank
    private BoardCategories boardCategories;
    private String content;
    @NotBlank(message = "제목을 입력하세요")
    @Size(min = 0, max = 255)
    private String title;
}
