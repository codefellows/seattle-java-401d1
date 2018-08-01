package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ControllerHome {
    @RequestMapping("/")
    public String home(Model model) {
        System.out.println("hit home controller");

        Date date = new Date();
        model.addAttribute("currenttime", date.toString());

        return "index";
    }
}
