package com.example.rbd_project.web.dto;

public class OrderDto {
    private long id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private String date;
    private int cost;

    public OrderDto(){}
    public OrderDto(long id, String type, int cost) {
        this.id = id;
        this.date = type;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
