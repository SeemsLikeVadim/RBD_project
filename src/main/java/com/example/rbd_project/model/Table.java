package com.example.rbd_project.model;




import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@javax.persistence.Table(name = "tables")
@Data
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String res_time;

    private int amount_of_people;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "table", fetch=FetchType.LAZY)
    private List<Order> orders;

    public Table() {
    }

    public Table(String res_time, int amount_of_people) {
        this.res_time = res_time;
        this.amount_of_people = amount_of_people;
    }
}
