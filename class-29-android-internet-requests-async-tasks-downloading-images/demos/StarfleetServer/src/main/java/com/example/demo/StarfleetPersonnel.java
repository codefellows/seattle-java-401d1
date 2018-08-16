package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="people")
public class StarfleetPersonnel {
    @Id
    @SequenceGenerator(name="starfleet-person")
    @GeneratedValue
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
