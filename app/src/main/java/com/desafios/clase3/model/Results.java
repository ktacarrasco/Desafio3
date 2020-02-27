package com.desafios.clase3.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    @SerializedName("correct_answer")
    private String correct_answer;
    @SerializedName("incorrect_answers")
    private List<String> Incorrect_answer;

    public Results(String category, String type, String difficulty, String question, String correct_answer, List<String> incorrect_answer) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        Incorrect_answer = incorrect_answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<String> getIncorrect_answer() {
        return Incorrect_answer;
    }

    public void setIncorrect_answer(List<String> incorrect_answer) {
        Incorrect_answer = incorrect_answer;
    }
}
