package com.mysite.sbb.Controller;

import com.mysite.sbb.Repository.ArticleRepository;
import com.mysite.sbb.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usr/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    //c
    @RequestMapping("doWrite")
    @ResponseBody
    public String doWrite(String title, String body){
        if(title == null || title.trim().length() == 0){
            return "제목을 입력해주세요.";
        }

        if(body == null || body.trim().length() == 0){
            return "내용을 입력해주세요.";
        }
        Article article = new Article();
        article.setTitle(title);
        article.setBody(body);
        article.setUpdateDate(LocalDateTime.now());
        article.setRegDate(LocalDateTime.now());
        article.setUserId(1L);
        articleRepository.save(article);
        return "%d게시물을 작성했습니다.".formatted(article.getId());
    }

    //r(read)
    @RequestMapping("list")
    @ResponseBody
    //전체조회
    public List<Article> showList(){
        return articleRepository.findAll();
    }

    @RequestMapping("detail")
    @ResponseBody
    //단건조회
    public Article showDetail(Long id){
        Article article = articleRepository.findById(id).get();
        return article;
    }

    //u(update)
    @RequestMapping("doModify")
    @ResponseBody
    public String doModify(Long id, String title, String body){
        if(!articleRepository.existsById(id)){
            return "%d번 게시물은 삭제되었거나 없는 게시물입니다.".formatted(id);
        }
        if(title == null || title.trim().length() == 0){
            return "제목을 입력해주세요.";
        }
        if(body == null || body.trim().length() == 0){
            return "내용을 입력해주세요.";
        }
        Article article = articleRepository.findById(id).get();
        article.setTitle(title);
        article.setBody(body);
        article.setUpdateDate(LocalDateTime.now());
        articleRepository.save(article);
        return "%d번 게시물이 수정되었습니다.".formatted(id);
    }

    //d
    @RequestMapping("doDelete")
    @ResponseBody
    public String doDelete(Long id){
        if(!articleRepository.existsById(id)){
            return "%d번 게시물은 이미 삭제되었거나 없는 게시물입니다.".formatted(id);
        }
        articleRepository.deleteById(id);
        return "%d번 게시물이 삭제되었습니다.".formatted(id);
    }
}
