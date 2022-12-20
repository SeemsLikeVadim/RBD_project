package com.example.rbd_project.model;



import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@javax.persistence.Table(name = "bartenders")
@Data
public class Bartender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    private int wor_exp;

    private String phone_number;

    private int salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bartender", fetch=FetchType.LAZY)
    private List<Order> orders;

    public Bartender() {
    }

    public Bartender(String fio, int wor_exp, String phone_number, int salary) {
        this.fio = fio;
        this.wor_exp =wor_exp;
        this.phone_number = phone_number;
        this.salary = salary;
    }
}
