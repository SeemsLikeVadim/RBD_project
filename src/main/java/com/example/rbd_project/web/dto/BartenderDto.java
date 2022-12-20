package com.example.rbd_project.web.dto;

public class BartenderDto {
    private long id;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    private String fio;

    private int wor_exp;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    private String phone_number;
    private int salary;

    public BartenderDto(){}
    public BartenderDto(long id, String fio, int wor_exp, String phone_number, int salary) {
        this.id = id;
        this.fio = fio;
        this.wor_exp = wor_exp;
        this.phone_number = phone_number;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWor_exp() {
        return wor_exp;
    }

    public void setWor_exp(int wor_exp) {
        this.wor_exp = wor_exp;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
