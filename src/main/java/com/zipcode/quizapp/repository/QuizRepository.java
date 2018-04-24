package com.zipcode.quizapp.repository;

import com.zipcode.quizapp.domain.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
