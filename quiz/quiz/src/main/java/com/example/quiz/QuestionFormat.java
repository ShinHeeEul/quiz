package com.example.quiz;


import com.example.quiz.Service.S3UploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
@Slf4j
@RequiredArgsConstructor
public class QuestionFormat {

    private final String beforeQuestion = "<div><div class=\"sc-55a68fa6-0 eOdQdY\"><div class=\"sc-55a68fa6-3 hqwwZt block\" style=\"text-align: start;\">";

    private final String endOfDiv = "</div>";
    private final String questionBeforeImg = "<div><picture><img src = \"";
    private final String questionAfterImg = "\"></picture>";

    private final String beforeSelectionLine = "<div class=\"sc-e1fad234-0 diwCQK\">";
    private final String beforeSelection = "<button class=\"sc-9d43cb05-0 brrCEx\"><div class=\"selection\"><svg width=\"100%\" height=\"100%\" viewBox=\"0 0 48 48\"><circle cx=\"24\" cy=\"24\" r=\"15.5\" fill=\"none\" stroke=\"#ccc\"></circle></svg></div><div class=\"sc-9d43cb05-2 ggNBga\">";
    private final String afterSelection = "</div><div class=\"sc-9d43cb05-3 fyrAIG\"></div></button>";
    private final String afterSelectionLine = "</div>";

    private final String beforeSolution = "<div><div>";
    private final String solutionBeforeImg = "<div><picture><img src = \"";
    private final String solutionAfterImg = "\"></picture>";

    private final S3UploadService s3UploadService;

    public String getQuestionWithFormat(String question, MultipartFile img, int num) {
        String htmlForm = beforeQuestion + question + endOfDiv;
        if(!img.isEmpty()) {
            String name = num + "_question." + StringUtils.getFilenameExtension(img.getOriginalFilename());
            String saveS3 = s3UploadService.saveFile(img, name);
            htmlForm = htmlForm + questionBeforeImg + saveS3 + questionAfterImg + endOfDiv;
        }
        htmlForm = htmlForm + endOfDiv + endOfDiv + endOfDiv;
        return htmlForm;
    }

    public String getSelectionWithFormat(String[] selection) {
        String htmlForm = beforeSelectionLine;
        String[] num = {"①","②","③","④","⑤","⑥","⑦","⑧","⑨","⑩",
        "⑪","⑫","⑬","⑭","⑮","⑯","⑰","⑱","⑲","⑳",
        "㉑","㉒", "㉓","㉔","㉕","㉖","㉗","㉘","㉙","㉚",
        "㉛","㉜","㉝","㉞","㉟","㊱","㊲","㊳","㊴","㊵",
        "㊶","㊷","㊸","㊹","㊺","㊻","㊼","㊽","㊾","㊿"};
        for(int i = 0; i < selection.length; i++) {
            htmlForm += beforeSelection;
            htmlForm += num[i];
            htmlForm += " ";
            htmlForm += selection[i];
            htmlForm += afterSelection;
        }
        htmlForm = htmlForm + afterSelectionLine;

        return htmlForm;
    }

    public String getSolutionWithFormat(String solution, MultipartFile img, int num) {
        String htmlForm = beforeSolution + solution + endOfDiv;
        if(!img.isEmpty()) {
            String name = num + "_solution." + StringUtils.getFilenameExtension(img.getOriginalFilename());
            String saveS3 = s3UploadService.saveFile(img, name);
            htmlForm = htmlForm + beforeSolution + solutionBeforeImg + saveS3 + solutionAfterImg + endOfDiv;
        }
        htmlForm = htmlForm + endOfDiv;
        return htmlForm;
    }
}
