package kr.co.wanted.wantedpreonboardingbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.wanted.wantedpreonboardingbackend.dto.ResponseDto;
import kr.co.wanted.wantedpreonboardingbackend.dto.ResponseStatus;
import kr.co.wanted.wantedpreonboardingbackend.dto.memberdto.LoginResponseDto;
import kr.co.wanted.wantedpreonboardingbackend.dto.memberdto.MemberRequestDto;
import kr.co.wanted.wantedpreonboardingbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/join")
	public ResponseDto<?> joinMember(MemberRequestDto memberRequestDto) {
		int code = memberService.join(memberRequestDto);
		if (code == -1) {
			return ResponseDto.of(ResponseStatus.INVALID_EMAIL, null);
		} else if (code == -2) {
			return ResponseDto.of(ResponseStatus.INVALID_PASSWORD, null);
		}
		return ResponseDto.of(ResponseStatus.SUCCESS, null);
	}

	@PostMapping("/login")
	public ResponseDto<?> loginMember(MemberRequestDto memberRequestDto) {
		LoginResponseDto loginResponseDto;
		try {
			loginResponseDto = memberService.login(memberRequestDto);
		} catch (IllegalArgumentException illegalArgumentException) {
			return ResponseDto.of(ResponseStatus.INVALID_LOGIN, null);
		} catch (IllegalStateException illegalStateException) {
			if (illegalStateException.getMessage().equals(ResponseStatus.INVALID_EMAIL.toString())) {
				return ResponseDto.of(ResponseStatus.INVALID_EMAIL, null);
			}
			return ResponseDto.of(ResponseStatus.INVALID_PASSWORD, null);
		}
		return ResponseDto.of(ResponseStatus.SUCCESS, loginResponseDto);
	}
}
