package com.example.onesignal;

public class Movie {

    private String id;
    private String title;
    private String info;
    private String rating;
    private String decription;
    private String url;

    public Movie(String id, String title, String info, String rating, String decription, String url) {
        this.id = id;
        this.title = title;
        this.info = info;
        this.rating = rating;
        this.decription = decription;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}