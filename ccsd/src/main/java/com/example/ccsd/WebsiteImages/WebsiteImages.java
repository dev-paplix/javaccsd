package com.example.ccsd.WebsiteImages;

import java.util.Base64;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WebsiteImage")
public class WebsiteImages {
    private String id;
    private String title;
    private String postShortDescription;
    private String date;
    private String tag;
    private String place;
    private String status;
    private String content;
    private String postSlug;
    private byte[] image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage64String() {
        return image64String;
    }

    public void setImage64String(String image64String) {
        this.image64String = image64String;
    }

    private String image64String;

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

    public String getpostShortDescription() {
        return postShortDescription;
    }

    public void setpostShortDescription(String postShortDescription) {
        this.postShortDescription = postShortDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public byte[] getimage() {
        return image;
    }

    public void setimage(byte[] image) {
        this.image = image;
    }




}
