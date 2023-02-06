package com.bfs.quizApp.domain;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class QuizQuestion {
    private int id;
    private int quiz_id;
    private int question_id;
    private int user_choice_id;
    private int order_num;

    // not from db
    private Question question;
    // private Choice usersChoice;

}
