package com.mysite.sbb.Article;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private String title;
    private String body;
    private long userId;

    public static interface ArticleRepository extends JpaRepository<Article, Long> {
        List<Article> findByTitle(String title);
        boolean existsByTitle(String title);
        List<Article> findByBody(String body);
        boolean existsByBody(String body);
        List<Article> findByTitleAndBody(String title, String body);
        boolean existsByTitleAndBody(String title, String body);
    }
}
