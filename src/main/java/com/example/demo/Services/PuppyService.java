package com.example.demo.Services;

import com.example.demo.Entities.Puppy;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PuppyService {

    List<Puppy> findAllPuppiesDescByScore();
    List<Puppy> findAll();
    void updateScore(List<Puppy> puppylist);
    
}
