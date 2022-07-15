package com.mysite.sbb.service;

import com.mysite.sbb.Repository.QuestionRepository;
import com.mysite.sbb.Util.DataNotFoundException;
import com.mysite.sbb.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        }else{ //예외처리
            throw new DataNotFoundException("question not found");
        }
    }
}
