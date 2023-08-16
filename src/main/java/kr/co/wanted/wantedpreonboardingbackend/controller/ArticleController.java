package kr.co.wanted.wantedpreonboardingbackend.controller;

import javax.servlet.http.HttpServletRequest;

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
	public ResponseDto<?> creatArticle(ArticleRequestDto articleRequestDto, HttpServletRequest httpServletRequest) {
		try {
			articleService.registerArticle(articleRequestDto, httpServletRequest);
		} catch (Exception e) {
			return ResponseDto.of(ResponseStatus.LoginInfo, null);
		}
		return ResponseDto.of(ResponseStatus.SUCCESS, null);
	}

	@GetMapping("/article/{articleId}")
	public ResponseDto<?> getArticle(@PathVariable String articleId) {
		return ResponseDto.of(ResponseStatus.SUCCESS, articleService.getArticle(Long.parseLong(articleId)));
	}

	@PutMapping("/article/{articleId}")
	public ResponseDto<?> updateArticle(@PathVariable String articleId, ArticleRequestDto articleRequestDto,
		HttpServletRequest httpServletRequest) {
		try {
			articleService.updateArticle(Long.parseLong(articleId), articleRequestDto, httpServletRequest);
		} catch (IllegalArgumentException illegalArgumentException) {
			return ResponseDto.of(ResponseStatus.ArticleAuthUpdate, null);
		}
		return ResponseDto.of(ResponseStatus.SUCCESS, null);
	}

	@DeleteMapping("/article/{articleId}")
	public ResponseDto<?> deleteArticle(@PathVariable String articleId, HttpServletRequest httpServletRequest) {
		try {
			articleService.deleteArticle(Long.parseLong(articleId), httpServletRequest);
		} catch (IllegalArgumentException illegalArgumentException) {
			return ResponseDto.of(ResponseStatus.ArticleAuthDelete, null);
		}
		return ResponseDto.of(ResponseStatus.SUCCESS, null);
	}
}
