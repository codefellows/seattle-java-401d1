package com.example.AuthDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/session")
    @ResponseBody
    public String hello(HttpServletRequest req) {
		Enumeration<String> headers = req.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			String value = req.getHeader(header);
			System.out.println(header + ": " + value);
		}
		req.getSession().setAttribute("stuff", "anything?");
		return "{\"message\":\"hi\"}";
	}

	@GetMapping
	public String homepage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		System.out.println(session.getId() + " " + username);
	    return "index";
	}
}
