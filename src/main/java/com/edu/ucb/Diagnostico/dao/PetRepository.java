package com.edu.ucb.Diagnostico.dao;
import com.edu.ucb.Diagnostico.entity.PetEntity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity,Long> {
}