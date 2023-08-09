package kr.co.wanted.wantedpreonboardingbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BoardController {

	@GetMapping("/test")
	public String hello() {
		log.info("test 호출");
		return "hello!";
	}
}
