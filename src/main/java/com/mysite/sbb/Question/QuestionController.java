package com.mysite.sbb.Question;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String qustionCreate(){
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@RequestParam String subject, @RequestParam String content){
        this.questionService.create(subject, content);
        return "redirect:/question/list";
    }
}
