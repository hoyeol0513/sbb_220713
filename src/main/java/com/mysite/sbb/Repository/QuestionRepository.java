package com.mysite.sbb.Repository;

import com.mysite.sbb.vo.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
