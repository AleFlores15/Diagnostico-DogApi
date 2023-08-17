package com.edu.ucb.Diagnostico.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "PET")
public class PetEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PET_ID")
    private Long petId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDATE")
    private Date birthdate;

    @Column(name = "BREED")
    private String breed;

    @Column(name = "STATUS")
    private boolean status;


    // Getters and setters

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    // to string

    @Override
    public String toString() {
        return "PetEntity{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", breed='" + breed + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    
}
