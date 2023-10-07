package com.example.quiz.Dto;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Builder
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionRequest {
    private String question;
    private MultipartFile questionImg;
    private String[] selection;
    private String solution;
    private MultipartFile solutionImg;

}
