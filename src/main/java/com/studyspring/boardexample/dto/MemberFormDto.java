package com.studyspring.boardexample.dto;

import com.studyspring.boardexample.domain.Member;
import com.studyspring.boardexample.domain.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class MemberFormDto {

    private final UserRole role = UserRole.USER;
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "영어 혹은 숫자만 입력 가능합니다.")
    @Length(min = 1, max = 10)
    @NotBlank(message = "ID is required field")
    private String username;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .username(this.username)
                .password(this.password)
                .role(this.role)
                .build();
    }
}
