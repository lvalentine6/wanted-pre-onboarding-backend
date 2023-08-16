package kr.co.wanted.wantedpreonboardingbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.wanted.wantedpreonboardingbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/join")
	public void joinMember() {

	}

	@PostMapping("/login")
	public void loginMember() {

	}
}
