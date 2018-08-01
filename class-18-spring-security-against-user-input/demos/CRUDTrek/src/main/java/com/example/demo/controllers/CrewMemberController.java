package com.example.demo.controllers;

import com.example.demo.model.CrewMember;
import com.example.demo.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/crew")
public class CrewMemberController {
    @Autowired
    CrewMemberRepository crewMemberRepository;

    @RequestMapping("/")
    @ResponseBody
    public List<CrewMember> getAll() {
        List<CrewMember> crew = crewMemberRepository.findAll();
        return crew;
    }

    @PostMapping("/")
    @ResponseBody
    public CrewMember create(
         @RequestParam String name,
         @RequestParam String rank,
         @RequestParam String shirtColor
    ) {
        CrewMember person = new CrewMember(name, rank, shirtColor);
        person = crewMemberRepository.save(person);
        return person;
    }
}
