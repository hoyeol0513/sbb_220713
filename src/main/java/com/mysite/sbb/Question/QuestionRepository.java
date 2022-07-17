package com.mysite.sbb.Question;

import com.mysite.sbb.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
