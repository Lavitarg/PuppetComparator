package com.example.demo.controllers;

import com.example.demo.Services.impl.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class HomePageController {

    @Autowired
    private AppUserServiceImpl appUserService;

    @GetMapping("/home")
    public String home(Principal principal){
        if(appUserService.getUserVoteStatus(principal)){
            return "redirect:rating";
        } else {
            return "home";
        }

    }
}
