package kr.co.wanted.wantedpreonboardingbackend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ArticleController {

	@GetMapping("/article/{articleId}")
	public void getArticle(@PathVariable String articleId) {

	}

	@GetMapping("/articles")
	public void listArticle() {

	}

	@PostMapping("/")
	public void creatArticle() {

	}

	@DeleteMapping("article/{articleId}")
	public void deleteArticle(@PathVariable String articleId) {

	}

	@PutMapping("article/{articleId}")
	public void updateArticle(@PathVariable String articleId) {

	}

	@GetMapping("/test")
	public String test() {
		return "test success!";
	}
}
