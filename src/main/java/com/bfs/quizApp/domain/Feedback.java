package com.bfs.quizApp.domain;

import lombok.*;

import java.sql.Date;

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
    private Date date;

    // not from db, not robust
    private User user;

}
