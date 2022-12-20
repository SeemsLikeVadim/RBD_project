package com.example.rbd_project.model;


import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "order_statuses")
@Data
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order_status", fetch=FetchType.LAZY)
    private List<Order> orders;

    public OrderStatus() {
    }

    public OrderStatus(String title) {
        this.title = title;
    }
}
