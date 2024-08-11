package com.quiz.service;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository){this.quizRepository=quizRepository;}

    @Override
    public Quiz get(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Id Not Found!!"));
    }

    @Override
    public List<Quiz> get() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
