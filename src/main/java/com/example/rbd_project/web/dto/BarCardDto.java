package com.example.rbd_project.web.dto;

public class BarCardDto {

    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    private int alcohol;

    public BarCardDto(){}
    public BarCardDto(long id, String title, int price, int alcohol) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.alcohol = alcohol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
