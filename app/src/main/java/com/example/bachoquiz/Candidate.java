package com.example.bachoquiz;

public class Candidate {
    private int id;
    private String CandidateName;

    public Candidate(int id, String candidateName) {
        this.id = id;
        CandidateName = candidateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandidateName() {
        return CandidateName;
    }

    public void setCandidateName(String candidateName) {
        CandidateName = candidateName;
    }
}
