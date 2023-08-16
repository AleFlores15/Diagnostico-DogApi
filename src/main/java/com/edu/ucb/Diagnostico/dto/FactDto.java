package com.edu.ucb.Diagnostico.dto;
import java.util.List;


public class FactDto {
    private List<String> facts;
    private boolean success;

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


}
