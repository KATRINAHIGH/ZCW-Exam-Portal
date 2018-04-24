package com.zipcode.quizapp.converters;


import com.zipcode.quizapp.commands.QuizForm;
import com.zipcode.quizapp.domain.Quiz;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class QuizFormToQuiz implements Converter<QuizForm, Quiz> {
    @Override
    public Quiz convert(QuizForm quizForm) {
        Quiz quiz = new Quiz();
        if (quizForm.getId() != null  && !StringUtils.isEmpty(quizForm.getId())) {
            quiz.set_id(new Long(quizForm.getId()));
        }
        quiz.setQuizName(quizForm.getQuizName());
        quiz.setSubject(quizForm.getSubject());
        quiz.setActions(quizForm.getActions());
        return quiz;
    }
}
