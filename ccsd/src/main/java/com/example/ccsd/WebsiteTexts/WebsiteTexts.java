package com.example.ccsd.WebsiteTexts;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "websitetexts")
public class WebsiteTexts {
    @Id
    private String id;

    private String author;
    private String postShortDescription;
    private String tag;
    private String place;
    private String title;
    private String postSlug;
    private String content;
    private String status;
    private String date;
    private String image;

    // Default constructor
    public WebsiteTexts() {
    }

    // Parameterized constructor
    public WebsiteTexts(String id, String author, String postShortDescription, String tag, String place, String title,
                        String postSlug, String content, String status, String date, String image) {
        this.id = id;
        this.author = author;
        this.postShortDescription = postShortDescription;
        this.tag = tag;
        this.place = place;
        this.title = title;
        this.postSlug = postSlug;
        this.content = content;
        this.status = status;
        this.date = date;
        this.image = image;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // toString method
    @Override
    public String toString() {
        return "WebsiteTexts{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", postShortDescription='" + postShortDescription + '\'' +
                ", tag='" + tag + '\'' +
                ", place='" + place + '\'' +
                ", title='" + title + '\'' +
                ", postSlug='" + postSlug + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
