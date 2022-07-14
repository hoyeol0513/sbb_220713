package com.mysite.sbb.Repository;

import com.mysite.sbb.vo.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
