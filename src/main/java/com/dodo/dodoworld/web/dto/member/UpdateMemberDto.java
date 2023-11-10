package com.dodo.dodoworld.web.dto.member;

import com.dodo.dodoworld.domain.Address;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class UpdateMemberDto {

    /**
     * 멤버 수정 Dto
     * - 검증요소 : 아이디, 비밀번호, 이름, 이메일, 생일, 주소**
     */

    @NotBlank
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
