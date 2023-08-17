package com.edu.ucb.Diagnostico.dto;
import java.util.List;


public class FactDto {
    private List<String> facts;
    private boolean success;

    private Long petId;


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

    //para pet id
    public Long getpetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
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
