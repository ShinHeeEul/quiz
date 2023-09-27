package com.example.quiz.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {


    //메인 화면 변경
    @GetMapping("/")
    public String home() {
        return "home";
    }

    //대분류 카테고리 접속
    @GetMapping("/main/{big}")
    public String BigCategory(@PathVariable Long big) {
        return null;
    }

    //소분류 카테고리 접속
    @GetMapping("/main/{big}/{small}")
    public String smallCategory(@PathVariable Long big, @PathVariable Long small) {
        return null;
    }
}
