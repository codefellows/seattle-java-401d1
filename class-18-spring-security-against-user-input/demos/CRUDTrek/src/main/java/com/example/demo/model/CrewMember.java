package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="crewmembers")
public class CrewMember {
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

    // requires default constructor
    public CrewMember(){}

    public CrewMember(String name, String rank, String shirtColor) {
        this.name = name;
        this.rank = rank;
        this.shirtColor = shirtColor;
    }
}
