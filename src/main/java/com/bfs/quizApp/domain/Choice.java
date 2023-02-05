package com.bfs.quizApp.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Choice {
    private int id;
    private int question_id;
    private String description;
    private boolean isCorrect;
}