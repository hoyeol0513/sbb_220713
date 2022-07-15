package com.mysite.sbb.service;

import com.mysite.sbb.Repository.QuestionRepository;
import com.mysite.sbb.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    }
}
