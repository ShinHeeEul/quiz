package com.example.quiz.Repository;

import com.example.quiz.Dao.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySmallCategory_Id(Long id);
}