package com.question.service;

import com.question.entities.Question;

import java.util.List;


public interface QuestionService {

    //Get all questions
    List<Question> get();

    //Get question by question_id
    Question get(Long id);

    //Get question by quizId
    List<Question> getByQuiz(Long id);

    //Save question
    Question save(Question question);
}
