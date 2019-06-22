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
    public String greeting( Model model) {


        List<Puppy> puppyList = puppyService.findAllPuppiesDescByScore();
        try {
            model.addAttribute("pic1", puppyList.get(0).getLinkToImage());
            model.addAttribute("pic2", puppyList.get(1).getLinkToImage());
            model.addAttribute("score1", puppyList.get(0).getScore());
            model.addAttribute("score2", puppyList.get(1).getScore());

        }catch (IndexOutOfBoundsException e){
            model.addAttribute("pic1", "error");
            model.addAttribute("pic2", "error");
        }

        return "rating";
    }
}
