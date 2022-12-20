package com.example.rbd_project.model;


import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "drink_orders")
@Data
public class DrinkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cost;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "bar_card_id")
    private BarCard bar_card;

    public DrinkOrder() {
    }

    public DrinkOrder(int cost) {
        this.cost = cost;
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
