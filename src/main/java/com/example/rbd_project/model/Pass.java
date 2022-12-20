package com.example.rbd_project.model;


import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "passes")
@Data
public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pass", fetch=FetchType.LAZY)
    private List<Client> clients;

    public Pass() {
    }

    public Pass(String type) {
        this.type = type;
    }
}
