package com.placesearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaceSearchController {

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/")
    public String index(){
        return "admin.html";
    }

    @GetMapping("/guest")
    public String guest(){
        return "guest.html";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin.html";
    }
}
