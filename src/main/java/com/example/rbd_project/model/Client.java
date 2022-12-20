package com.example.rbd_project.model;


import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    private int age;
    private String reg_stat;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "pass_id")
    private Pass pass;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch=FetchType.LAZY)
    private List<Order> order;

    public Client() {
    }

    public Client(String fio, int age, String reg_stat) {
        this.fio = fio;
        this.age = age;
        this.reg_stat = reg_stat;
    }
    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }
}

