package com.example.rbd_project.model;


import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "bar_cards")
@Data
public class BarCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer price;

    private Integer alcohol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bar_card", fetch=FetchType.LAZY)
    private List<DrinkOrder> drink_order;

    public BarCard() {
    }

    public BarCard(String title, int price, int alcohol) {
        this.title = title;
        this.price = price;
        this.alcohol = alcohol;
    }
}
