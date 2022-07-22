package com.mysite.sbb.Question.controller;

import com.mysite.sbb.Answer.AnswerForm;
import com.mysite.sbb.Question.QuestionForm;
import com.mysite.sbb.Question.domain.Question;
import com.mysite.sbb.Question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/question")
//autowired 없이도 자동으로 생성자를 만들어줌.
@AllArgsConstructor
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping("/list")
    //@ResponseBody를 떼면 알아서 템플릿을 찾아감.
    public String showQuestions(Model model, @RequestParam(value="page", defaultValue="0") int page){
        //페이지 별로 리스트를 가져오도록 수정하기 paging으로
        Page<Question> paging = questionService.getList(page);
        model.addAttribute("paging",paging);
        return "question_list";
    }

    @RequestMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String qustionCreate(QuestionForm questionForm){
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {//에러가 있다면 다시 질문등록 form(question_form 으로 이동)
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
