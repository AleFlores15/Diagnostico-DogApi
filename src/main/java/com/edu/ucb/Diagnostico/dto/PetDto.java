package com.edu.ucb.Diagnostico.dto;

import java.util.Date;

public class PetDto {
    private Long petId;
    private String name;
    private Date birthdate;
    private String breed;
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
                ", status=" + status +
                '}';
    }
    
}
