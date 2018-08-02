package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="crewmembers")
public class CrewMember implements Comparable<CrewMember>{
    @Id
    @GeneratedValue(generator = "crewmember_generator")
    @SequenceGenerator(
            name = "crewmember_generator",
            sequenceName = "crewmember_sequence",
            initialValue = 1003
    )
    public long id;
    public String name;
    public String rank;
    @Column(name="shirtcolor")
    public String shirtColor;
    public int votes;

    // requires default constructor
    public CrewMember(){}

    public CrewMember(String name, String rank, String shirtColor) {
        this.name = name;
        this.rank = rank;
        this.shirtColor = shirtColor;
    }

    @Override
    // return -1 if this is less than the other one
    // return  0 if these two things are equal
    // return  1 if this is greater than the other one
    public int compareTo(CrewMember o) {
        return o.votes - this.votes;
    }
}
