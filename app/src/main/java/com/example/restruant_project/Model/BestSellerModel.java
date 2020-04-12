package com.example.restruant_project.Model;

public class BestSellerModel {
    int id,img;
    String name,description;
    String price;

    public BestSellerModel(int id, int img, String name, String description, String price) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public BestSellerModel(int img, String name, String description, String price) {
        this.img = img;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
