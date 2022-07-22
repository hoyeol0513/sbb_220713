package com.mysite.sbb.Answer.controller;

import com.mysite.sbb.Answer.AnswerForm;
import com.mysite.sbb.Answer.service.AnswerService;
import com.mysite.sbb.Question.domain.Question;
import com.mysite.sbb.Question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/answer")
@AllArgsConstructor //final이 된 answerService를 받기위함.
public class AnswerController {
    @Autowired
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult){
        Question question = this.questionService.getQuestion(id); //해당 질문에 대한 답변이 필요
        //답변 검증
        if(bindingResult.hasErrors()) {//에러가 있으면 질문상세페이지로(답변 다시달기)
            model.addAttribute("question", question);
            return "question_detail";
        }
        //해당 질문에 답변만들기
        this.answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }

    @PostMapping("/like/{questionId}/{answerId}")
    public String clickLike (@PathVariable("questionId") Integer questionId, @PathVariable("answerId") Integer answerId){
        this.answerService.setLike(answerId); //answerService에 저장
        return String.format("redirect:/question/detail/%s", questionId); //setLike 후에 다시 해당 질문 페이지로
    }
}
