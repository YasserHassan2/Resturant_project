package com.example.restruant_project.Model;

public class ProductModel {
    String id,name,desc,price;
    int img,qunitiy;

    public ProductModel(String name, String desc, String price, int img) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.img = img;
    }

    public ProductModel(String id, String name, String desc, String price, int img, int qunitiy) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.img = img;
        this.qunitiy = qunitiy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getQunitiy() {
        return qunitiy;
    }

    public void setQunitiy(int qunitiy) {
        this.qunitiy = qunitiy;
    }
}
