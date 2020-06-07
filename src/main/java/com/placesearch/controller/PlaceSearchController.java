package com.placesearch.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaceSearchController {

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/")
    public String index(Authentication auth, Model model) {

        UserDetails user = (UserDetails) auth.getPrincipal();
        model.addAttribute("userName",user.getUsername());

        return "index.html";
    }

    @GetMapping("/basic")
    public String guest() {
        return "basic.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin.html";
    }
}
