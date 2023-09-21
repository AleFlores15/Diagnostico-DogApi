package com.edu.ucb.Diagnostico.dto;
import java.util.Date;
import java.util.List;


public class ApiDto {
    private List<String> facts;
    private Date start_date;
    private boolean status;
    private Long petId;


    public List<String> getFacts() {
        return facts;
    }

    public void setFacts(List<String> facts) {
        this.facts = facts;
    }

    public Long getpetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date= start_date;
    }

    // toSting
    @Override
    public String toString() {
        return "FactDto{" +
                "facts=" + facts +
                
                '}';
    }


}
