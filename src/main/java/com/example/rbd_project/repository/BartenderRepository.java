package com.example.rbd_project.repository;

import com.example.rbd_project.model.Bartender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BartenderRepository extends JpaRepository<Bartender, Long> {
}
