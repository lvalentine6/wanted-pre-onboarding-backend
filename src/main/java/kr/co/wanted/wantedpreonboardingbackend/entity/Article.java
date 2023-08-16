package kr.co.wanted.wantedpreonboardingbackend.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.LastModifiedBy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private Long articleId;

	@JoinColumn(name = "writer_id")
	@ManyToOne
	private Member writer;

	@Column(name = "title")
	private String title;

	@Column(name = "contents")
	private String contents;

	@LastModifiedBy
	@Column(name = "last_modified_at")
	private LocalDateTime lastModifiedAt;

	public Article(Member writer, String title, String contents, LocalDateTime lastModifiedAt) {
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.lastModifiedAt = lastModifiedAt;
	}

	public void updateTitleAndContents(String title, String contents) {
		this.title = title;
		this.contents = contents;
		this.lastModifiedAt = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Article{" +
			"articleId=" + articleId +
			", writer=" + writer +
			", title='" + title + '\'' +
			", contents='" + contents + '\'' +
			", lastModifiedAt=" + lastModifiedAt +
			'}';
	}
}
