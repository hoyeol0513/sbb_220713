package com.mysite.sbb.Controller;

import com.mysite.sbb.Repository.QuestionRepository;
import com.mysite.sbb.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Question> showQuestions(){
        return questionRepository.findAll();
    }
}
