package com.question.controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question save(@RequestBody Question question){
        return questionService.save(question);
    }

    @GetMapping
    public List<Question> get(){
        return questionService.get();
    }

    @GetMapping("/{id}")
    public Question get(@PathVariable Long id){
        return questionService.get(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getByQuiz(@PathVariable Long quizId){
        return questionService.getByQuiz(quizId);
    }


}
