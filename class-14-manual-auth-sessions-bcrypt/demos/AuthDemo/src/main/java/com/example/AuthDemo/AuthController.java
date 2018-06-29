package com.example.AuthDemo;

import com.example.AuthDemo.db.UserDB;
import com.example.AuthDemo.models.User;
import com.example.AuthDemo.pojos.UserPojo;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
@SessionAttributes("username")
public class AuthController {
    @PostMapping("/register")
    public ModelAndView register(@RequestParam String username, @RequestParam String password, @RequestParam String bio) {
        ModelAndView mv = new ModelAndView();

        if (UserDB.getUserByName(username) != null) {
            mv.setViewName("loginerror");
            mv.addObject("error", "Sorry, that username already exists. Choose another.");
        } else {
            UserDB.createUser(username, password, bio);
            mv.setViewName("loggedin");
            mv.addObject("username", username);
        }
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        ModelAndView mv = new ModelAndView();

        User user = UserDB.getUserByName(username);
        if (user == null) {
            mv.setViewName("loginerror");
            mv.addObject("error", "Username not found. Choose another.");
        } else if(user.checkPassword(password)) {
            mv.setViewName("loginerror");
            mv.addObject("error", "Wrong password. Try again.");
        } else {
            mv.setViewName("loggedin");
            mv.addObject("username", username);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }

        return mv;
    }

    @PostMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("loggedout");
    }

    @GetMapping("/sessiondata")
    @ResponseBody
    public String getSessionData(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("username");
    }

}
