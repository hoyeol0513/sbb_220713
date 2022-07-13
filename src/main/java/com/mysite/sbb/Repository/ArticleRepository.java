package com.mysite.sbb.Repository;

import com.mysite.sbb.vo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
    boolean existByTitle(String title);
    List<Article> findByBody(String body);
    boolean existByBody(String body);
    List<Article> findByTitleAndBody(String title, String body);
    boolean existByTitleAndBody(String title, String body);
}
