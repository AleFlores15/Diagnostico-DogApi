package com.edu.ucb.Diagnostico.dto;
import java.util.List;


public class FactDto {
    private List<String> facts;
    private boolean success;

    private Long AnimalId;

    // Constructores, getters y setters

    public List<String> getFacts() {
        return facts;
    }

    public void setFacts(List<String> facts) {
        this.facts = facts;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    //para animal id
    public Long getAnimalId() {
        return AnimalId;
    }

    public void setPetId(Long AnimalId) {
        this.AnimalId = AnimalId;
    }
    // toSting
    @Override
    public String toString() {
        return "FactDto{" +
                "facts=" + facts +
                ", success=" + success +
                '}';
    }


}
