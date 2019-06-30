package com.example.demo.controllers;

import com.example.demo.Services.impl.AppUserServiceImpl;
import com.example.demo.Services.impl.PuppyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class RatingController {

    @Autowired
    private PuppyServiceImpl puppyService;

    @Autowired
    private AppUserServiceImpl appUserService;

    @GetMapping("/rating")
    public String showRating(Model model, Principal principal) {
        if(appUserService.getUserVoteStatus(principal)) {
            model.addAttribute("puppies", puppyService.findAllPuppiesDescByScore());
            return "rating";
        } else{
            return "redirect:home";
        }
    }

}
