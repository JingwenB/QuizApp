package com.bfs.quizApp.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String email;
    private String password;
    private String firstName;
    //TODO add phone number
    private String lastName;
    private boolean isAdmin;
    private boolean isActive;

}
