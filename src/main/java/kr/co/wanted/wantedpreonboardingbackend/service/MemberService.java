package kr.co.wanted.wantedpreonboardingbackend.service;

import org.springframework.stereotype.Service;

import kr.co.wanted.wantedpreonboardingbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public void creat() {
	}
}
