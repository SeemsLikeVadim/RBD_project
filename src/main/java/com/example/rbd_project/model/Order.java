package com.example.rbd_project.model;

import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private Integer cost;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "order_status_id")
    private OrderStatus order_status;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "bartender_id")
    private Bartender bartender;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private com.example.rbd_project.model.Table table;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch=FetchType.LAZY)
    private List<DrinkOrder> drink_order;

    public Order() {
    }

    public Order(String date, int cost) {
        this.date = date;
        this.cost = cost;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
