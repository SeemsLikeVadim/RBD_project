package com.example.rbd_project.repository;

import com.example.rbd_project.model.BarCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarCardRepository extends JpaRepository<BarCard, Long> {
}
