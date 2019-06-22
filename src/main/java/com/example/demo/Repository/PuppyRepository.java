package com.example.demo.Repository;

import com.example.demo.Entities.Puppy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PuppyRepository extends CrudRepository<Puppy, Long> {

    List<Puppy> findAllByOrderByScoreDesc();
    List<Puppy> findAll();

}
