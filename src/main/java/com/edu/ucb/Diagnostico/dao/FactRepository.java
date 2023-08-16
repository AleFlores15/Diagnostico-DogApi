package com.edu.ucb.Diagnostico.dao;

import com.edu.ucb.Diagnostico.entity.FactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactRepository extends JpaRepository<FactEntity,Long> { }
