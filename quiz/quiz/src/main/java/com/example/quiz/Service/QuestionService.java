package com.example.quiz.Service;

import com.example.quiz.Model.Question;
import com.example.quiz.Model.SmallCategory;
import com.example.quiz.Repository.QuestionRepository;
import com.example.quiz.Repository.SmallCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {


    private final QuestionRepository questionRepository;
    private final SmallCategoryRepository smallCategoryRepository;


    public List<Question> getQuestionsBySmall(Long smallId) {
        return questionRepository.findBySmallCategory_Id(smallId);
    }

    public SmallCategory getSmallCategoryById(Long smallId) {
        return smallCategoryRepository.findById(smallId).get();
    }

    public int getSizeBySmall(long smallId) {
        return questionRepository.findBySmallCategory_Id(smallId).size();
    }

    public void add(Question question) {
        questionRepository.save(question);
    }

    public void remove(Long id) {
        questionRepository.deleteById(id);
    }
}
