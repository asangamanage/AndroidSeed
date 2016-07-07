package com.example.androidseed.models;

/**
 * Created by asangamanage on 19/05/2016.
 */
public class Flower {
    public int productId;
    public String category;
    public double price;
    public String instructions;
    public String photo;
    public String name;

    public String imageUrl;

    public Flower(int productId, String category, double price, String instructions, String photo, String name) {
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.instructions = instructions;
        this.photo = photo;
        this.name = name;
    }

    public Flower(int productId, String category, double price, String instructions, String photo, String name , String imageUrl) {
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.instructions = instructions;
        this.photo = photo;
        this.name = name;
    }
}
