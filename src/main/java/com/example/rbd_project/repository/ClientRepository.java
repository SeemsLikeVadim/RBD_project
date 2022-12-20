package com.example.rbd_project.repository;

import com.example.rbd_project.model.Bartender;
import com.example.rbd_project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
