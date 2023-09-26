package com.example.quiz.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @GetMapping("/{id}")
    public String showQuiz(@PathVariable Long id) {
        return "quiz";
    }

    //퀴즈 정답 확인

    //해설 추가

    //랜덤 문제 추출

    //문제 추가 api
}
