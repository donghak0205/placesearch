package com.placesearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaceSearchController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/guest")
    public void guest(){

    }

    @GetMapping("/admin")
    public void admin(){

    }
}
