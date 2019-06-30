package com.example.demo.controllers;

import com.example.demo.Entities.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomePageController {

    @GetMapping("/home")
    public String home(Principal principal){

        return "home";
    }
}
