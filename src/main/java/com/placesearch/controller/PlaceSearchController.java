package com.placesearch.controller;

import com.placesearch.domain.MySearchHistory;
import com.placesearch.domain.SearchResult;
import com.placesearch.repository.MySearchHistoryRepository;
import com.placesearch.repository.SearchResultRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;


@Controller
public class PlaceSearchController {

    @Autowired
    SearchResultRepository searchResultRepository;

    @Autowired
    MySearchHistoryRepository mySearchHistoryRepository;

    @GetMapping("/login")
    public String login() {

        return "login.html";
        //return "modalTest.html";
    }

    @GetMapping("/")
    public String index(Authentication auth, Model result) {

        UserDetails user = (UserDetails) auth.getPrincipal();
        result.addAttribute("userName",user.getUsername());
        result.addAttribute("result", searchResultRepository.findAll());
        result.addAttribute("selectParameter", searchResultRepository.selectParameter());
        result.addAttribute("mySearchHistory", mySearchHistoryRepository.selectMySearchHistory(user.getUsername())); //내검색히스토리 불러오기

        return "index.html";
    }

    //make Search Result List
    @PostMapping("/makeList")
    public String  makeList(Authentication auth, @RequestBody JSONObject response) {

        UserDetails user = (UserDetails) auth.getPrincipal();

        Timestamp createdDate = null;

        //meta
        HashMap<String, Object> meta = (HashMap<String, Object>) response.get("meta");
        HashMap<String, String> same_name = (HashMap<String, String>) meta.get("same_name");

        //document
        ArrayList<HashMap<String,String>> documents = (ArrayList<HashMap<String, String>>) response.get("documents");

        searchResultRepository.deleteAll();
        IntStream.rangeClosed(0,documents.size()-1).forEach(
                i->searchResultRepository.save(new SearchResult(
                        documents.get(i).get("place_name"),
                        documents.get(i).get("phone"),
                        documents.get(i).get("address_name"),
                        documents.get(i).get("category_name"),
                        documents.get(i).get("place_url"),
                        documents.get(i).get("id"),
                        documents.get(i).get("x"),
                        documents.get(i).get("y"),
                        same_name.get("keyword"),
                        meta.get("pageable_count"),
                        meta.get("total_count")
                ))

        );

        MySearchHistory mySeacrhHistory = new MySearchHistory(user.getUsername(),same_name.get("keyword"));

        mySearchHistoryRepository.save(mySeacrhHistory);

        return "redirect:/";
    }

}

