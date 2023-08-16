package kr.co.wanted.wantedpreonboardingbackend.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kr.co.wanted.wantedpreonboardingbackend.dto.articledto.ArticleRequestDto;
import kr.co.wanted.wantedpreonboardingbackend.dto.articledto.ArticleResponseDto;
import kr.co.wanted.wantedpreonboardingbackend.dto.articledto.ArticleResponseListDto;
import kr.co.wanted.wantedpreonboardingbackend.entity.Article;
import kr.co.wanted.wantedpreonboardingbackend.entity.Member;
import kr.co.wanted.wantedpreonboardingbackend.repository.ArticleRepository;
import kr.co.wanted.wantedpreonboardingbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {

	private static final int PAGE_SIZE = 10;
	private final ArticleRepository articleRepository;
	private final MemberRepository memberRepository;

	public ArticleResponseListDto getArticleList(int page) {
		PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE);
		Page<Article> articlesPage = articleRepository.findAll(pageRequest);
		return ArticleResponseListDto.ofPage(articlesPage);
	}

	public void registerArticle(ArticleRequestDto articleRequestDto) {
		Member member1 = memberRepository.findById(1L).orElseThrow();
		Article article = new Article(member1, articleRequestDto.getTitle(), articleRequestDto.getContents(),
			LocalDateTime.now());
		articleRepository.save(article);
	}

	public ArticleResponseDto getArticle(Long articleId) {
		Member member1 = memberRepository.findById(1L).orElseThrow();
		return ArticleResponseDto.from(articleRepository.findById(articleId).orElseThrow());
	}

	@Transactional
	public void updateArticle(Long articleId, ArticleRequestDto articleRequestDto) {
		Member member1 = memberRepository.findById(1L).orElseThrow();
		Article article = articleRepository.findById(articleId).orElseThrow();
		article.updateTitleAndContents(articleRequestDto.getTitle(), articleRequestDto.getContents());
	}

	@Transactional
	public void deleteArticle(Long articleId) {
		Member member1 = memberRepository.findById(1L).orElseThrow();
		articleRepository.deleteById(articleId);
	}

}
