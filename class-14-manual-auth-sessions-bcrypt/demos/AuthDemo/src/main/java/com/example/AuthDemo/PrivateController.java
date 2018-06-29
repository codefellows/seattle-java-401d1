package com.example.AuthDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateController {
    @RequestMapping("/*")
    public ModelAndView handlePrivateRequests(HttpServletRequest request) {
        String servlet = request.getServletPath();
        System.out.println(servlet);

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            mv.setViewName("secret");
        } else {
            mv.setViewName("accessdenied");
        }

        return mv;
    }
}
