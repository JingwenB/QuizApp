package com.bfs.quizApp.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String subject;
    private String message;

    // not from db, not robust

}
