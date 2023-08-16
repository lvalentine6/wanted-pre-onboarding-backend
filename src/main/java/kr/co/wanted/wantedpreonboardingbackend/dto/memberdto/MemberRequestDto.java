package kr.co.wanted.wantedpreonboardingbackend.dto.memberdto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequestDto {
	private String email;
	private String password;
}
