package com.example.rbd_project.web.dto;

public class TableDto {
    private long id;


    private String res_time;

    private int amount_of_people;

    public TableDto(){}
    public TableDto(long id, String res_time, int amount_of_people) {
        this.id = id;
        this.res_time = res_time;
        this.amount_of_people = amount_of_people;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRes_time() {
        return res_time;
    }

    public void setRes_time(String res_time) {
        this.res_time = res_time;
    }

    public int getAmount_of_people() {
        return amount_of_people;
    }

    public void setAmount_of_people(int amount_of_people) {
        this.amount_of_people = amount_of_people;
    }
}
