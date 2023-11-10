package com.dodo.dodoworld.web.dto.board;

import com.dodo.dodoworld.domain.BoardCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResponseBoardDto {
    /**
     * 글 응답 Dto
     * - 검증요소 : 작성자, 카테고리, 글제목
     */

    @NotBlank
    private String writer; // 작성자 userId값
    @NotBlank
    private BoardCategories boardCategories;
    private String content;
    @NotBlank(message = "제목을 입력하세요")
    @Size(min = 0, max = 255)
    private String title;
    private int like;
}
