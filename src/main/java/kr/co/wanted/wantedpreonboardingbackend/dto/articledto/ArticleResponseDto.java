package kr.co.wanted.wantedpreonboardingbackend.dto.articledto;

import java.time.LocalDateTime;

import kr.co.wanted.wantedpreonboardingbackend.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleResponseDto {
	private Long articleId;
	private String writer;
	private LocalDateTime lastModifiedAt;
	private String title;
	private String contents;

	public static ArticleResponseDto from(Article article) {
		return new ArticleResponseDto(
			article.getArticleId(),
			article.getWriter().getEmail(),
			article.getLastModifiedAt(),
			article.getTitle(),
			article.getContents()
		);
	}
}
