package com.quiz.service;

import com.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {

    //To get single quiz
    Quiz get(Long id);

    //To get list of quiz
    List<Quiz> get();

    //Save new quiz
    Quiz save(Quiz quiz);
}
