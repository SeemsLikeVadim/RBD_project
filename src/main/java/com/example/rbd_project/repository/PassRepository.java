package com.example.rbd_project.repository;


import com.example.rbd_project.model.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {
}
