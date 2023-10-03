package com.example.quiz.Repository;

import com.example.quiz.Model.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmallCategoryRepository extends JpaRepository<SmallCategory, Long> {
    List<SmallCategory> findByBigCategory_Id(Long id);
}