package com.mysite.sbb.Repository;

import com.mysite.sbb.vo.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
