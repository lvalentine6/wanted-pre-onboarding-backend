package kr.co.wanted.wantedpreonboardingbackend.dto.articledto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import kr.co.wanted.wantedpreonboardingbackend.entity.Article;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class ArticleResponseListDto {
	private final List<ArticleResponseDto> articles;
	private final int currentPage;
	private final int totalPages;

	private ArticleResponseListDto(List<ArticleResponseDto> articles, int currentPage, int totalPages) {
		this.articles = articles;
		this.currentPage = currentPage;
		this.totalPages = totalPages;
	}

	public static ArticleResponseListDto ofPage(Page<Article> articlePage) {
		List<ArticleResponseDto> articleResponseDtos = articlePage.getContent()
			.stream()
			.map(a -> new ArticleResponseDto(a.getArticleId(), a.getWriter().getEmail(), a.getLastModifiedAt(),
				a.getTitle(), a.getContents()))
			.collect(Collectors.toList());
		return new ArticleResponseListDto(articleResponseDtos, articlePage.getNumber(), articlePage.getTotalPages());
	}
}
