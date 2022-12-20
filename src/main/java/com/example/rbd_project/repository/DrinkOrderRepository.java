package com.example.rbd_project.repository;

import com.example.rbd_project.model.DrinkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkOrderRepository extends JpaRepository<DrinkOrder, Long> {
}
