package com.mysite.sbb.Question;

import com.mysite.sbb.Answer.AnswerForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/question")
//autowired 없이도 자동으로 생성자를 만들어줌.
@AllArgsConstructor
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping("/list")
    //@ResponseBody를 떼면 알아서 템플릿을 찾아감.
    public String showQuestions(Model model){
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList",questionList);
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
