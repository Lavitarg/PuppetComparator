package com.example.demo.controllers;

import com.example.demo.Entities.Puppy;
import com.example.demo.Repository.PuppyRepository;
import com.example.demo.Services.impl.PuppyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    List<Puppy> puppyList;
    Iterator<Puppy> puppyIterator;
    Puppy puppy1;
    Puppy puppy2;

    //при переходе на страницу голосования создается лист со случайным порядком картинок
    @GetMapping("/vote")
    public String voteStart(Model model){
//        инициализируем лист с картинками и перемешиваем его
        puppyList = puppyService.findAll();
        puppyIterator = puppyList.listIterator();
        Collections.shuffle(puppyList);

        return "votePage";
    }

//    вызывается при первой загрузке страницы голосования или при клике на картинку\кнопку
    @GetMapping("/updatechoices")
    public String updateChoicesAjax(@RequestParam(name="choice", required=false) String choice, Model model ){
//      если была нажата кнопка или картинка, обновляем данные в БД
        if(choice!=null){
            switch(choice) {
                case ("1"):
                    puppyService.updateScore(puppy1);
                case ("2"):
                    puppyService.updateScore(puppy2);
            }
        }
//        если лист с картинками закончился, отдаем информацию о конце голосования
        if(!puppyIterator.hasNext()){
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
