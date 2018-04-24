package com.zipcode.quizapp.services;

import com.zipcode.quizapp.commands.QuizForm;
import com.zipcode.quizapp.domain.Quiz;

import java.util.List;

public interface QuizService {

    List<Quiz> listAll();

    Quiz getById(Long Id);

    Quiz saveOrUpdate(Quiz quiz);

    void delete(Long id);

    Quiz saveOrUpdateQuizForm(QuizForm quizform);
}

