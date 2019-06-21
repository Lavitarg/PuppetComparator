package com.example.demo.controllers;

import com.example.demo.Entities.Puppet;
import com.example.demo.Repository.PuppetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class RateController {

    @Autowired
    PuppetRepository puppetRepository;

    @GetMapping("/rating")
    public String greeting( Model model) {


        List<Puppet> puppetList = puppetRepository.findAllByOrderByScoreDesc();
//        try{
//            Collections.shuffle(puppetList);
//        }catch (NullPointerException e){
//            System.out.println(e.getCause());
//        }
        try {
            model.addAttribute("pic1", puppetList.get(0).getLinkToImage());
            model.addAttribute("pic2", puppetList.get(1).getLinkToImage());
            model.addAttribute("score1", puppetList.get(0).getScore());
            model.addAttribute("score2", puppetList.get(1).getScore());

        }catch (IndexOutOfBoundsException e){
            model.addAttribute("pic1", "error");
            model.addAttribute("pic2", "error");
        }

        return "rating";
    }
}
