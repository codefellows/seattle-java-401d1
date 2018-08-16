package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/starfleet")
public class StarfleetController {
    @Autowired
    StarfleetPersonnelRepository mPersonnelDB;

    @GetMapping
    @ResponseBody
    public List<StarfleetPersonnel> getAll() {
        List<StarfleetPersonnel> all = mPersonnelDB.findAll();
        return all;
    }
}
