package com.example.quiz;


public class QuestionFormat {

    //TODO: Format 만들기
    private final String beforeQuestion = "<div><p>";
    private final String questionBeforeImg = "</p><img>";
    private final String questionAfterImg = "</img></div>";

    private final String beforeSelectionLine = "<div>";
    private final String beforeSelection = "<p>";
    private final String afterSelection = "</p>";
    private final String afterSelectionLine = "</div>";

    private final String beforeSolution = "<div><p>";
    private final String solutionBeforeImg = "</p><img>";
    private final String solutionAfterImg = "</img></div>";

    public String getQuestionWithFormat(String question, String img) {
        return beforeQuestion + question + questionBeforeImg + img + questionAfterImg;
    }

    public String getSelectionWithFormat(String[] selection) {
        String s = beforeSelectionLine;
        for(int i = 0; i < selection.length; i++) {
            s += beforeSelection;
            s += selection[i];
            s += afterSelection;
        }
        s += afterSelectionLine;

        return s;
    }

    public String getSolutionWithFormat(String solution, String img) {
        return beforeSolution + solution + solutionBeforeImg + img + solutionAfterImg;
    }
}
