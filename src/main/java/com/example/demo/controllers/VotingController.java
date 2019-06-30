package com.example.demo.controllers;

import com.example.demo.Entities.Puppy;
import com.example.demo.Repository.PuppyRepository;
import com.example.demo.Services.impl.AppUserServiceImpl;
import com.example.demo.Services.impl.PuppyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//отвечает за страницы голосования
@Controller
public class VotingController {

    @Autowired
    PuppyRepository puppyRepository;
    @Autowired
    PuppyServiceImpl puppyService;
    @Autowired
    AppUserServiceImpl appUserService;

    private List<Puppy> puppyList;
    private List<Puppy> chosenPuppiesList;
    private Iterator<Puppy> puppyIterator;
    private Puppy puppy1;
    private Puppy puppy2;

    //при переходе на страницу голосования создается лист со случайным порядком картинок
    @GetMapping("/vote")
    public String voteStart(Model model, Principal principal){

        if(appUserService.getUserVoteStatus(principal)){
            return "redirect:rating";
        }
//        инициализируем лист с картинками и перемешиваем его
        puppyList = puppyService.findAll();
        puppyIterator = puppyList.listIterator();
        Collections.shuffle(puppyList);
        chosenPuppiesList = new ArrayList<>();


        return "votePage";
    }

//    вызывается при первой загрузке страницы голосования или при клике на картинку\кнопку
    @GetMapping("/updatechoices")
    public String updateChoicesAjax(@RequestParam(name="choice", required=false) String choice, Model model, Principal principal){
//      если была нажата кнопка или картинка, добавляем в отделньый лист вариант, за который проголосовали
        if(choice!=null){
            switch(choice) {
                case ("1"):
                    chosenPuppiesList.add(puppy1);
                case ("2"):
                    chosenPuppiesList.add(puppy2);
            }
        }
//        если лист с вариантами закончился, отдаем информацию о конце голосования и обновляем очки у выбранных вариантов
        if(!puppyIterator.hasNext()){
            puppyService.updateScore(chosenPuppiesList);
            appUserService.setUserVoted(principal);
            return "voteEnd";
//            иначе отображаем следующую пару
        }else {
            puppy1 = puppyIterator.next();
            puppy2 = puppyIterator.next();
            model.addAttribute("puppyImage1", puppy1.getLinkToImage());
            model.addAttribute("puppyImage2", puppy2.getLinkToImage());
            return "voteChoices";
        }
    }

}
