package com.yahoo.reservation.web.controller;

import com.yahoo.reservation.entity.User;
import com.yahoo.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class MeetingRoomController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String root(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("hey");
        System.out.println(auth.getName());
        User user = userRepository.findByUserId(auth.getName());
        model.addAttribute("loggedInUser", user);
        return "room/index";
    }
}
