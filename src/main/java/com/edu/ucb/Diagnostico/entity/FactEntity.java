package com.edu.ucb.Diagnostico.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "FACT")
public class FactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fact_id")
    private int factId;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "fact")
    private String fact;
    
    @Column(name = "pet_id")
    private Long petId;

    // Constructor, getters, setters

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

    public Date getStart_date(){
        return start_date;
    }

    public void setStart_date(Date start_date){
        this.start_date= start_date;
    }

    public Long getpetId() {
        return petId;
    }

    public void setpetId(Long petId) {
        this.petId = petId;
    }

    public Boolean getStatus(){
        return status;   
    }

    public void setStatus(Boolean status){
        this.status= status;
    }

    // to string
    @Override
    public String toString() {
        return "FactEntity{" +
                "factId=" + factId +
                ", fact='" + fact + '\'' +
                ", petId=" + petId +
                '}';
    }

}