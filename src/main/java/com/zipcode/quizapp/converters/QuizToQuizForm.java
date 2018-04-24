package com.zipcode.quizapp.converters;


import com.zipcode.quizapp.commands.QuizForm;
import com.zipcode.quizapp.domain.Quiz;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuizToQuizForm implements Converter<Quiz, QuizForm> {
    @Override
    public QuizForm convert(Quiz quiz) {
        QuizForm quizForm = new QuizForm();
        quizForm.setId(quiz.get_id());
        quizForm.setQuizName(quiz.getQuizName());
        quizForm.setSubject(quiz.getSubject());
        quizForm.setActions(quiz.getActions());
        return quizForm;
    }
}

