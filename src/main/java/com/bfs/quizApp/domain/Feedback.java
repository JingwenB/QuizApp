package com.bfs.quizApp.domain;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback {
    private int id;
    private int user_id;
    private String message;
    private int rating;
    private Timestamp date;


}
