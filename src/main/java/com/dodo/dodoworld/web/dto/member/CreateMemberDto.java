package com.dodo.dodoworld.web.dto.member;

import com.dodo.dodoworld.domain.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CreateMemberDto {
    /**
     * 멤버 생성 Dto
     * - 검증요소 : 아이디, 비밀번호, 이름, 이메일, 생일, 주소**
     */

    @NotBlank
    @Max(value = 20, message = "아이디는 최대 20자를 넘을 수 없습니다.")
    @Min(value = 2, message = "아이디는 최대 2글자 이상이여야 합니다.")
    private String userId;
    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;
    @NotBlank
    private String username;
    @NotBlank
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotBlank
    private LocalDateTime birth;
    @NotBlank
    private Address address;

}
