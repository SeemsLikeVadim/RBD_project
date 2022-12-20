package com.example.rbd_project.web.dto;

public class OrderStatusDto {
    private long id;

    private String title;

    public OrderStatusDto(){}
    public OrderStatusDto(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
