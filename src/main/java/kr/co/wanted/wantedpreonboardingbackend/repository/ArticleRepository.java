package kr.co.wanted.wantedpreonboardingbackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.wanted.wantedpreonboardingbackend.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
