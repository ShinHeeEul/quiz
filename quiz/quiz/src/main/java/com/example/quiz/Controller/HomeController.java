package com.example.quiz.Controller;

import com.example.quiz.Model.BigCategory;
import com.example.quiz.Model.Question;
import com.example.quiz.Model.SmallCategory;
import com.example.quiz.Dto.QuestionRequestDto;
import com.example.quiz.QuestionFormat;
import com.example.quiz.Repository.BigCategoryRepository;
import com.example.quiz.Repository.SmallCategoryRepository;
import com.example.quiz.Service.QuestionService;
import com.example.quiz.Service.SmallCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final QuestionService questionService;
    private final SmallCategoryService smallCategoryService;
    private final BigCategoryRepository bigCategoryRepository;
    private final SmallCategoryRepository smallCategoryRepository;

    //메인 화면 변경
    @GetMapping("/")
    public String home(Model model) {
        List<BigCategory> bigCategories = bigCategoryRepository.findAll();
        model.addAttribute("big", bigCategories);
        return "home";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String addQuestion(@RequestParam QuestionRequestDto questionRequestDto) {

        QuestionFormat questionFormat = new QuestionFormat();
        Question question = Question.builder()
                .num(questionService.getSizeBySmall(0L) + "번")
                .code("[MINE]")
                .question(questionFormat.getQuestionWithFormat(questionRequestDto.getQuestion(), questionRequestDto.getQuestionImg()))
                .selection(questionFormat.getSelectionWithFormat(questionRequestDto.getSelection()))
                .solution(questionFormat.getSolutionWithFormat(questionRequestDto.getSolution(), questionRequestDto.getSolutionImg()))
                .smallCategory(smallCategoryService.get(0L))
                .build();
        questionService.add(question);
        //bigCategory 0번 - 내꺼
        return "/home";
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
