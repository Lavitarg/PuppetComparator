package com.example.demo.controllers;

import com.example.demo.Entities.AppUser;
import com.example.demo.Services.impl.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    @Autowired
    private AppUserServiceImpl appUserService;

    @GetMapping("/registration")
    public String register(RedirectAttributes redirectAttributes, Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(AppUser user, RedirectAttributes redirectAttributes){
        if(appUserService.saveUniqUser(user)) {
            redirectAttributes.addFlashAttribute("success", "Registration successful!");
            return "redirect:login";
        }else {
            redirectAttributes.addFlashAttribute("error", "This login already exists!");
            return "redirect:registration";
        }
    }

}
