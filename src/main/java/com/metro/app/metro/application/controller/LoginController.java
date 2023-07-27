package com.metro.app.metro.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metro.app.metro.application.entity.User;
import com.metro.app.metro.application.repository.UserRepository;

@Controller
public class LoginController {
    @Autowired
	private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login (@RequestParam ("username") String username,
    		             @RequestParam ("password") String password,
    		             Model model) {
    	User user = userRepository.findByUsername(username);
    	if (user != null && user.getPassword().equals(password))
    	{
    		model.addAttribute("");
    		return "devicedetails";
    	} else {
    		model.addAttribute("Invalid username or password.");
    		return "loginerror";
    	}


    }


}
