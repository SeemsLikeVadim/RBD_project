package com.example.rbd_project.web.dto;

public class DrinkOrderDto {
    private long id;

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    private Integer cost;

    public DrinkOrderDto(){}
    public DrinkOrderDto(long id, Integer cost) {
        this.id = id;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
