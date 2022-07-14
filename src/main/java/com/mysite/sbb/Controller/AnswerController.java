package com.mysite.sbb.Controller;

import com.mysite.sbb.Repository.AnswerRepository;
import com.mysite.sbb.vo.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @RequestMapping("list")
    @ResponseBody
    public List<Answer> showAnswer(){
        return answerRepository.findAll();
    }
}
