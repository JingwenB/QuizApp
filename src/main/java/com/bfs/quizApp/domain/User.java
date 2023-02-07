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
    private String lastName;

    private String phone;
    private String address;
    private boolean isAdmin;
    private boolean isActive;

}
