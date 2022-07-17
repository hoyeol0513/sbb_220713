package com.mysite.sbb.Answer;

import com.mysite.sbb.Question.QuestionService;
import com.mysite.sbb.Question.Question;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@AllArgsConstructor //final이 된 answerService를 받기위함.
public class AnswerController {
    @Autowired
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
        Question question = this.questionService.getQuestion(id); //해당 질문에 대한 답변이 필요
        //질문만들기
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
