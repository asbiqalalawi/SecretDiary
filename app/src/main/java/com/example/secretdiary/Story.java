package com.example.secretdiary;

public class Story {
    private String Date;
    private String Title;
    private String Clock;
    private int Photo;

    public Story (){

    }

    public Story(String date, String title, String clock, int photo) {
        Date = date;
        Title = title;
        Clock = clock;
        Photo = photo;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getClock() {
        return Clock;
    }

    public void setClock(String clock) {
        this.Clock = clock;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
