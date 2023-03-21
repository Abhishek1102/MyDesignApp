package com.example.mydesignapp.model;

public class FaqModel {
    private String question;
    private String answer;
    private boolean is_selected = false;

    public FaqModel(String question, String answer, boolean is_selected) {
        this.question = question;
        this.answer = answer;
        this.is_selected = is_selected;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isIs_selected() {
        return is_selected;
    }

    public void setIs_selected(boolean is_selected) {
        this.is_selected = is_selected;
    }
}
