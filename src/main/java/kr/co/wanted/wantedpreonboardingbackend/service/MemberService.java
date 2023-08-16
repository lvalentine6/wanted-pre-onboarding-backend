package kr.co.wanted.wantedpreonboardingbackend.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import kr.co.wanted.wantedpreonboardingbackend.auth.JwtUtil;
import kr.co.wanted.wantedpreonboardingbackend.dto.ResponseStatus;
import kr.co.wanted.wantedpreonboardingbackend.dto.memberdto.LoginResponseDto;
import kr.co.wanted.wantedpreonboardingbackend.dto.memberdto.MemberRequestDto;
import kr.co.wanted.wantedpreonboardingbackend.entity.Member;
import kr.co.wanted.wantedpreonboardingbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;
	private final JwtUtil jwtUtil;
	private final int PASSWORD_MIN = 8;
	private final String EMAIL_SEPARATOR = "@";

	public int join(MemberRequestDto memberRequestDto) {
		if (isValidEmail(memberRequestDto.getEmail())) {
			return -1;
		}

		if (isValidPassword(memberRequestDto.getPassword())) {
			return -2;
		}
		String salt = BCrypt.gensalt();
		String hashPassword = BCrypt.hashpw(memberRequestDto.getPassword(), salt);
		Member member = new Member(memberRequestDto.getEmail(), hashPassword);
		memberRepository.save(member);
		return 0;
	}

	public LoginResponseDto login(MemberRequestDto memberRequestDto) {
		if (isValidEmail(memberRequestDto.getEmail())) {
			throw new IllegalStateException(ResponseStatus.INVALID_EMAIL.toString());
		}

		if (isValidPassword(memberRequestDto.getPassword())) {
			throw new IllegalStateException(ResponseStatus.INVALID_PASSWORD.toString());
		}

		String password = memberRequestDto.getPassword();
		String hashPassword = memberRepository.findByEmail(memberRequestDto.getEmail()).get().getPassword();

		if (!BCrypt.checkpw(password, hashPassword)) {
			throw new IllegalArgumentException();
		}

		Optional<Member> member = memberRepository.findByEmailAndPassword(memberRequestDto.getEmail(), hashPassword);
		if (member.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return new LoginResponseDto(jwtUtil.generateToken(member.get().getMemberId(), member.get().getEmail()));
	}

	private boolean isValidEmail(String email) {
		List<String> list = Arrays.asList(email.split(""));
		return !list.contains(EMAIL_SEPARATOR);
	}

	private boolean isValidPassword(String password) {
		return password.length() < PASSWORD_MIN;
	}
}
