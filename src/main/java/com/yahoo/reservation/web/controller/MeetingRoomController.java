package com.yahoo.reservation.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class MeetingRoomController {
    @GetMapping("/")
    public String root() {
        return "room/index";
    }
}
