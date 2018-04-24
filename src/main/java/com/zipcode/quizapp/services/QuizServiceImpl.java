package com.zipcode.quizapp.services;

import com.zipcode.quizapp.commands.QuizForm;
import com.zipcode.quizapp.converters.QuizFormToQuiz;
import com.zipcode.quizapp.domain.Quiz;
import com.zipcode.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;
    private QuizFormToQuiz quizFormToQuiz;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, QuizFormToQuiz quizFormToQuiz ){
        this.quizRepository = quizRepository;
        this.quizFormToQuiz = quizFormToQuiz;
    }

    @Override
    public List<Quiz> listAll() {
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll().forEach(quizzes::add); //fun with Java 8
        return quizzes;
    }

    @Override
    public Quiz getById(Long id){
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public Quiz saveOrUpdate(Quiz quiz){
        quizRepository.save(quiz);
        return quiz;
    }

    @Override
    public void delete(Long id){
        quizRepository.deleteById(id);
    }

    @Override
    public Quiz saveOrUpdateQuizForm(QuizForm quizForm) {
        Quiz savedQuiz = saveOrUpdate(quizFormToQuiz.convert(quizForm));

        System.out.println("Saved Quiz Id: " + savedQuiz.get_id());
        return savedQuiz;
    }

}





