package com.example.quiz.Dto;


import lombok.*;

@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionRequestDto {
    private String question;
    private String questionImg;
    private String[] selection;
    private String solution;
    private String solutionImg;

}
