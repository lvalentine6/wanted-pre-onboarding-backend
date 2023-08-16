package kr.co.wanted.wantedpreonboardingbackend.dto.articledto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleRequestDto {
	private String title;
	private String contents;
}
