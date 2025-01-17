package com.example.ccsd.Products;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
public class Products {


    private String title; // from productController
    private String postSlug;
    private String postShortDescription;
    private String tag;
    private String place;
    private String dateProduct;
    private String status;
    private byte[] imageStore;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public void setPostShortDescription(String postShortDescription) {
        this.postShortDescription = postShortDescription;
    }

    public String getPostShortDescription() {
        return postShortDescription;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setDateProduct(String dateProduct) {
        this.dateProduct = dateProduct;
    }

    public String getDateProduct() {
        return dateProduct;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setImageStore(byte[] imageStore) {
        this.imageStore = imageStore;
    }

    public byte[] getImageStore() {
        return imageStore;
    }
}
