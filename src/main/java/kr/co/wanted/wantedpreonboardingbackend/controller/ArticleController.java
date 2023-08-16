package kr.co.wanted.wantedpreonboardingbackend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.wanted.wantedpreonboardingbackend.dto.ResponseDto;
import kr.co.wanted.wantedpreonboardingbackend.dto.ResponseStatus;
import kr.co.wanted.wantedpreonboardingbackend.dto.articledto.ArticleRequestDto;
import kr.co.wanted.wantedpreonboardingbackend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

	private final ArticleService articleService;

	@GetMapping("/articles")
	public ResponseDto<?> listArticle(@RequestParam int page) {
		return ResponseDto.of(ResponseStatus.SUCCESS, articleService.getArticleList(page));
	}

	@PostMapping("/article")
	public ResponseDto<?> creatArticle(ArticleRequestDto articleRequestDto) {
		articleService.registerArticle(articleRequestDto);
		return ResponseDto.of(ResponseStatus.SUCCESS, null);
	}

	@GetMapping("/article/{articleId}")
	public ResponseDto<?> getArticle(@PathVariable String articleId) {
		return ResponseDto.of(ResponseStatus.SUCCESS, articleService.getArticle(Long.parseLong(articleId)));
	}

	@PutMapping("/article/{articleId}")
	public ResponseDto<?> updateArticle(@PathVariable String articleId, ArticleRequestDto articleRequestDto) {
		articleService.updateArticle(Long.parseLong(articleId), articleRequestDto);
		return ResponseDto.of(ResponseStatus.SUCCESS, null);
	}

	@DeleteMapping("/article/{articleId}")
	public ResponseDto<?> deleteArticle(@PathVariable String articleId) {
		articleService.deleteArticle(Long.parseLong(articleId));
		return ResponseDto.of(ResponseStatus.SUCCESS, null);
	}
}
