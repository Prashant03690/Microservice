package com.question.service;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;
    public QuestionServiceImpl(QuestionRepository questionRepository){this.questionRepository = questionRepository;}

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found!"));
    }

    @Override
    public List<Question> getByQuiz(Long id) {
        return questionRepository.findByQuizId(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }
}
