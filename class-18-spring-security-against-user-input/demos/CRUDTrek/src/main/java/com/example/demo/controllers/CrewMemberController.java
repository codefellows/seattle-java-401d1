package com.example.demo.controllers;

import com.example.demo.model.CrewMember;
import com.example.demo.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/crew")
public class CrewMemberController {
    @Autowired
    CrewMemberRepository crewMemberRepository;

    @RequestMapping("/")
    @ResponseBody
    public List<CrewMember> getAll() {
        List<CrewMember> crew = crewMemberRepository.findAll();
        Collections.sort(crew);
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

    @GetMapping("/{id}/upvote")
    public String upvote(
            @PathVariable("id") long id
    ) {
        Optional optional = crewMemberRepository.findById(id);
        CrewMember person = (CrewMember) optional.get();
        if (person != null) {
            person.votes++;
            crewMemberRepository.save(person);
        }
        return "redirect:/";
    }
}
