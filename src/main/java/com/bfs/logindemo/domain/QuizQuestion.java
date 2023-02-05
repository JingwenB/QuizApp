package com.bfs.logindemo.domain;

import lombok.*;

import java.util.List;


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

    //  not from db
    private Question question;
//    private Choice correctChoice;

}
