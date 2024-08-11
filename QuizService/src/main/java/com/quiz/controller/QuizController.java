package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService){this.quizService=quizService;}

    @PostMapping
    public Quiz save(@RequestBody Quiz quiz){
        return quizService.save(quiz);
    }

    @GetMapping
    public List<Quiz> getAll(){
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz get(@PathVariable Long id){
        return quizService.get(id);
    }


}
