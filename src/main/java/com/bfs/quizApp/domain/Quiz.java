package com.bfs.quizApp.domain;

import lombok.*;


import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Quiz {
    private int id;
    private int user_id;
    private String category;
    private String name;
    private Timestamp time_start;
    private Timestamp time_end;
    // not from db
    private List<QuizQuestion> quizQuestions;
    private User user;
    private String grade;
    private String is_passed;

    public void setGrade() {
        int count = quizQuestions.size();
        int corrected = 0;
        for(QuizQuestion qq: quizQuestions){
            if (qq.getQuestion().getCorrect_choice().getId() == qq.getUser_choice_id()){
                corrected ++;
            }
        }
        this.is_passed = corrected > count/2 ? "passed" : "failed";
        this.grade = corrected + "/" +count;

    }

}
