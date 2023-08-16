package com.edu.ucb.Diagnostico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FACT")
public class FactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int factId;

    private String fact;

    private Long animalId;

    // Constructor, getters, setters, y otros métodos si es necesario

    public int getFactId() {
        return factId;
    }

    public void setFactId(int factId) {
        this.factId = factId;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    // to string
    @Override
    public String toString() {
        return "FactEntity{" +
                "factId=" + factId +
                ", fact='" + fact + '\'' +
                ", animalId=" + animalId +
                '}';
    }

}