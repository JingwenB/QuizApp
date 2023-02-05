package com.bfs.quizApp.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question {
    private int id;
    private String category;
    private String description;
    private boolean isActive;

    // not from db
    private List<Choice> choices;
    private Choice correct_choice;

    public void setCorrect_choice() {
        for(Choice c: this.choices ){
            if(c.isCorrect()){
                this.correct_choice = c;
            }
        }
    }
}
