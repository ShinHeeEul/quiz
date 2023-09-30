package com.example.quiz.Controller;

import com.example.quiz.Dao.BigCategory;
import com.example.quiz.Dao.SmallCategory;
import com.example.quiz.Repository.BigCategoryRepository;
import com.example.quiz.Repository.SmallCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BigCategoryRepository bigCategoryRepository;
    private final SmallCategoryRepository smallCategoryRepository;

    //메인 화면 변경
    @GetMapping("/")
    public String home(Model model) {
        List<BigCategory> bigCategories = bigCategoryRepository.findAll();
        model.addAttribute("big", bigCategories);
        return "home";
    }

    //대분류 카테고리 접속
    @GetMapping("/main/{big}")
    public String BigCategory(@PathVariable Long big, Model model) {
        List<SmallCategory> smallCategories = smallCategoryRepository.findByBigCategory_Id(big);
        model.addAttribute("big", big);
        model.addAttribute("small", smallCategories);
        return "sub_home";
    }

}
