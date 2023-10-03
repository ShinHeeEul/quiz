package com.example.quiz.Service;

import com.example.quiz.Model.SmallCategory;
import com.example.quiz.Repository.SmallCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmallCategoryService {

    private final SmallCategoryRepository smallCategoryRepository;

    public SmallCategory get(Long id) {
        return smallCategoryRepository.findById(id).get();
    }
}
