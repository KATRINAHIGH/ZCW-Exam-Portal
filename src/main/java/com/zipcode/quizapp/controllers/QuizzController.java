package com.zipcode.quizapp.controllers;

import com.zipcode.quizapp.commands.QuizForm;
import com.zipcode.quizapp.converters.QuizToQuizForm;
import com.zipcode.quizapp.domain.Quiz;
import com.zipcode.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class QuizzController {

    private QuizService quizService;
    private QuizToQuizForm quizToQuizForm;

    @Autowired
    public void setProductToProductForm(QuizToQuizForm quizToQuizForm) {
        this.quizToQuizForm = quizToQuizForm;
    }

    @Autowired
    public void setProductService(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/quiz/list";
    }

    @RequestMapping({"/quiz/list", "/quiz"})
    public String listQuizzes(Model model){
        model.addAttribute("quizzes", quizService.listAll());
        return "quiz/list";
    }

    @RequestMapping("/quiz/show/{id}")
    public String getQuiz(@PathVariable String id, Model model){
        model.addAttribute("quiz", quizService.getById(Long.valueOf(id)));
        return "quiz/show";
    }

    @RequestMapping("quiz/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Quiz quiz = quizService.getById(Long.valueOf(id));
        QuizForm quizForm = quizToQuizForm.convert(quiz);

        model.addAttribute("quizForm", quizForm);
        return "quiz/quizform";
    }

    @RequestMapping("/quiz/new")
    public String newQuiz(Model model){
        model.addAttribute("quizForm", new QuizForm());
        return "quiz/quizform";
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public String saveOrUpdateQuiz(@Valid QuizForm quizForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "quiz/quizform";
        }

        Quiz savedQuiz = quizService.saveOrUpdateQuizForm(quizForm);

        return "redirect:/quiz/show/" + savedQuiz.get_id();
    }

    @RequestMapping("/quiz/delete/{id}")
    public String delete(@PathVariable String id){
        quizService.delete(Long.valueOf(id));
        return "redirect:/quiz/list";
    }


}




