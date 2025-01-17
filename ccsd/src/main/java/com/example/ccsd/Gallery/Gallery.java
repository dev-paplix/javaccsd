package com.example.ccsd.Gallery;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document(collection = "Gallery")
public class Gallery {

    private String title;
    private String postSlug;
    private String postShortDescription;
    private String tag;
    private String place;
    private String date;
    private String status;
    private String image;
    private String content;

    public Gallery() {
    }

    public Gallery(String title, String postSlug, String postShortDescription, String tag, String place, String date, String status, String image, String content) {
        this.title = title;
        this.postSlug = postSlug;
        this.postShortDescription = postShortDescription;
        this.tag = tag;
        this.place = place;
        this.date = date;
        this.status = status;
        this.image = image;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public String getPostShortDescription() {
        return postShortDescription;
    }

    public void setPostShortDescription(String postShortDescription) {
        this.postShortDescription = postShortDescription;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "title='" + title + '\'' +
                ", postSlug='" + postSlug + '\'' +
                ", postShortDescription='" + postShortDescription + '\'' +
                ", tag='" + tag + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


