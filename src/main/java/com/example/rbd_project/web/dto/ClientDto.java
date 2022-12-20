package com.example.rbd_project.web.dto;

public class ClientDto {

    private long id;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    private String fio;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public String getReg_stat() {
        return reg_stat;
    }

    public void setReg_stat(String reg_stat) {
        this.reg_stat = reg_stat;
    }

    private String reg_stat;

    public ClientDto(){}
    public ClientDto(long id, String fio, int age, String reg_stat) {
        this.id = id;
        this.fio = fio;
        this.age = age;
        this.reg_stat = reg_stat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
