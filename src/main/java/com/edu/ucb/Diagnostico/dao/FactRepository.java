package com.edu.ucb.Diagnostico.dao;

import com.edu.ucb.Diagnostico.entity.FactEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FactRepository extends JpaRepository<FactEntity,Long>  {
    @Query(value = "SELECT * FROM fact WHERE pet_id = :petId", nativeQuery = true)
    Page <FactEntity> findAllbyPetId(@Param("petId")Long petId, Pageable pageable);
 }
