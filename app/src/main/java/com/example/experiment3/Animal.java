package com.example.experiment3;

public class Animal {
    private String name;
    private int imageResId; // 图片的资源ID

    public Animal(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}