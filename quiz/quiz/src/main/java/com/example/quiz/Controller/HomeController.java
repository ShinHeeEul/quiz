package com.example.quiz.Controller;

import com.example.quiz.Model.BigCategory;
import com.example.quiz.Model.Question;
import com.example.quiz.Model.SmallCategory;
import com.example.quiz.Dto.QuestionRequest;
import com.example.quiz.QuestionFormat;
import com.example.quiz.Repository.BigCategoryRepository;
import com.example.quiz.Repository.SmallCategoryRepository;
import com.example.quiz.Service.QuestionService;
import com.example.quiz.Service.SmallCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final QuestionService questionService;
    private final SmallCategoryService smallCategoryService;
    private final BigCategoryRepository bigCategoryRepository;
    private final SmallCategoryRepository smallCategoryRepository;
    private final QuestionFormat questionFormat;

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
    public String addQuestion(QuestionRequest questionRequest) {
        int num = questionService.getSizeBySmall(0L);
        Question question = Question.builder()
                .num(num + "번")
                .code("[MINE]")
                .question(questionFormat.getQuestionWithFormat(questionRequest.getQuestion(), questionRequest.getQuestionImg(), num))
                .selection(questionFormat.getSelectionWithFormat((questionRequest.getSelection()!=null)? questionRequest.getSelection():new String[0]))
                .solution(questionFormat.getSolutionWithFormat(questionRequest.getSolution(), questionRequest.getSolutionImg(), num))
                .smallCategory(smallCategoryService.get(0L))
                .build();
        questionService.add(question);
        //bigCategory 0번 - 내꺼
        return "redirect:/";
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
