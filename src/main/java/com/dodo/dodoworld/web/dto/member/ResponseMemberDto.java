package com.dodo.dodoworld.web.dto.member;

import com.dodo.dodoworld.domain.Address;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ResponseMemberDto {

    /**
     * 멤버 응답 Dto
     * - 검증요소 : 아이디, 이름, 이메일, 생일, 주소**
     */

    @NotBlank
    @Max(value = 20, message = "아이디는 최대 20자를 넘을 수 없습니다.")
    @Min(value = 2, message = "아이디는 최대 2글자 이상이여야 합니다.")
    private String userId;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private LocalDateTime birth;
    @NotBlank
    private Address address;
}
