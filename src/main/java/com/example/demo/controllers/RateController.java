package com.example.demo.controllers;

import com.example.demo.Entities.Puppy;
import com.example.demo.Repository.PuppyRepository;
import com.example.demo.Services.PuppyService;
import com.example.demo.Services.impl.PuppyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RateController {

    @Autowired
    PuppyServiceImpl puppyService;

    @GetMapping("/rating")
    public String showRating(Model model) {
        model.addAttribute("puppies",puppyService.findAllPuppiesDescByScore());
        return "rating";
    }
}
