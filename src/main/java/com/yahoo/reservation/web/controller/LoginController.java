package com.yahoo.reservation.web.controller;

import com.yahoo.reservation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.yahoo.reservation.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/mypage")
    public String mypage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        User user = userRepository.findByUserId(auth.getName());
        model.addAttribute("loggedInUser", user);
        return "mypage";
    }
}
