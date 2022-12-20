package com.example.rbd_project.repository;

import com.example.rbd_project.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
}
