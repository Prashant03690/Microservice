package com.quiz.service;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuizRepository quizRepository;
    private final QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient){
        this.quizRepository=quizRepository;
        this.questionClient=questionClient;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz =  quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Id Not Found!!"));
        quiz.setQuestions(questionClient.getQuestionsByQuiz(id));
        return quiz;
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsByQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
