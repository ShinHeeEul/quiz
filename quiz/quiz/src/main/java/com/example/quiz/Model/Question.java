package com.example.quiz.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String num;
    private String code;
    @Column(columnDefinition = "LONGTEXT")
    private String question;
    @Column(columnDefinition = "LONGTEXT")
    private String selection;
    @Column(columnDefinition = "LONGTEXT")
    private String solution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "small_category_id")
    private SmallCategory smallCategory;

}
