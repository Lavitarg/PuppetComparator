package com.example.demo.Services.impl;

import com.example.demo.Entities.Puppy;
import com.example.demo.Repository.PuppyRepository;
import com.example.demo.Services.PuppyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuppyServiceImpl implements PuppyService {
    @Autowired
    PuppyRepository puppyRepository;
    @Override
    public List<Puppy> findAllPuppiesDescByScore() {
        return puppyRepository.findAllByOrderByScoreDesc();
    }

    @Override
    public List<Puppy> findAll() {
        return puppyRepository.findAll();
    }

    @Override
    public void updateScore(List<Puppy> puppyList) {
        for(Puppy puppy:puppyList) {
            puppy.setScore(puppy.getScore()+1);
            puppyRepository.save(puppy);
        }
    }

}
