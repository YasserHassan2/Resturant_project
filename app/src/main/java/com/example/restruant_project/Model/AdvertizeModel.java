package com.example.restruant_project.Model;

public class AdvertizeModel {

    String title;
    int id,image;

    public AdvertizeModel(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public AdvertizeModel(String title, int id, int image) {
        this.title = title;
        this.id = id;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
