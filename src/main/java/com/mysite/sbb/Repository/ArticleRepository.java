package com.mysite.sbb.Repository;

import com.mysite.sbb.vo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
    boolean existsByTitle(String title);
    List<Article> findByBody(String body);
    boolean existsByBody(String body);
    List<Article> findByTitleAndBody(String title, String body);
    boolean existsByTitleAndBody(String title, String body);
}
