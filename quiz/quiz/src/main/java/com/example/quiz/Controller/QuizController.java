package com.example.quiz.Controller;


import com.example.quiz.Model.Question;
import com.example.quiz.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuestionService questionService;

    @GetMapping("/{big}/{small}/{id}")
    public String showQuiz(@PathVariable Long big, @PathVariable Long small, @PathVariable Long id, Model model) {
        List<Question> questions = questionService.getQuestionsBySmall(small);
        Question question = questions.get(Math.toIntExact(id-1));

        Long next = (id < questions.size())?id + 1:-1;
        Long prev = (id > 1)?id-1:-1;

        model.addAttribute("id", question.getId());
        model.addAttribute("big", big);
        model.addAttribute("small", small);
        model.addAttribute("prev", prev);
        model.addAttribute("next", next);
        model.addAttribute("num", id + "번");
        model.addAttribute("code", question.getCode());
        model.addAttribute("question",question.getQuestion());
        model.addAttribute("selection", question.getSelection());
        model.addAttribute("solution", question.getSolution());

        return "quiz";
    }
    @DeleteMapping("/{id}")
    public String removeQuiz(@PathVariable Long id) {
        questionService.remove(id);
        return "redirect:/";
    }

    //todo: 랜덤 문제 추출

    @GetMapping("/random")
    public String createRandomQuiz() {
        return "create_random";
    }

    @PostMapping("/random")
    public String showRandomQuiz() {
        /*List<Question> questions = questionService.getQuestionsBySmall(small);
        Question question = questions.get(Math.toIntExact(id-1));

        Long next = (id < questions.size())?id + 1:-1;
        Long prev = (id > 1)?id-1:-1;

        model.addAttribute("id", question.getId());
        model.addAttribute("big", big);
        model.addAttribute("small", small);
        model.addAttribute("prev", prev);
        model.addAttribute("next", next);
        model.addAttribute("num", id + "번");
        model.addAttribute("code", question.getCode());
        model.addAttribute("question",question.getQuestion());
        model.addAttribute("selection", question.getSelection());
        model.addAttribute("solution", question.getSolution());*/
        return "redirect:/";
    }

}
