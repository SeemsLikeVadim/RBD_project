package com.example.rbd_project.web.dto;

public class PassDto {

    private long id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public PassDto(){}
    public PassDto(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
