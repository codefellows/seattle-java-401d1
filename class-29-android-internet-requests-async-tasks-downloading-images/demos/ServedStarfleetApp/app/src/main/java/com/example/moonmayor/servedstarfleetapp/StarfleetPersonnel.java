package com.example.moonmayor.servedstarfleetapp;

public class StarfleetPersonnel {
    public long id;
    public String name;
    public String rank;
    public String bio;

    public StarfleetPersonnel() {}

    public StarfleetPersonnel(String name, String rank, String bio) {
        this.name = name;
        this.rank = rank;
        this.bio = bio;
    }
}


