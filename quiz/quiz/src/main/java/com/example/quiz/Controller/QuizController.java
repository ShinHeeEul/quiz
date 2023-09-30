package com.example.quiz.Controller;


import com.example.quiz.Dao.Question;
import com.example.quiz.Dao.SmallCategory;
import com.example.quiz.Repository.QuestionRepository;
import com.example.quiz.Repository.SmallCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuestionRepository questionRepository;
    private final SmallCategoryRepository smallCategoryRepository;

    @GetMapping("/{big}/{small}/{id}")
    public String showQuiz(@PathVariable Long big, @PathVariable Long small, @PathVariable Long id, Model model) {
        List<Question> questions = questionRepository.findBySmallCategory_Id(small);
        Optional<SmallCategory> smallCategory = smallCategoryRepository.findById(small);
        Question question = questions.get(Math.toIntExact(id-1));

        Long next = (id < questions.size())?id + 1:-1;
        Long prev = (id > 1)?id-1:-1;

        model.addAttribute("big", big);
        model.addAttribute("small", small);
        model.addAttribute("prev", prev);
        model.addAttribute("next", next);
        model.addAttribute("num", question.getNum());
        model.addAttribute("code", question.getCode());
        model.addAttribute("question",question.getQuestion());
        model.addAttribute("selection", question.getSelection());
        model.addAttribute("solution", question.getSolution());

        return "quiz";
    }

    //해설 추가

    //랜덤 문제 추출

    //문제 추가 api
}
