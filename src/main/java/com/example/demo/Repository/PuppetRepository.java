package com.example.demo.Repository;

import com.example.demo.Entities.Puppet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PuppetRepository extends Repository<Puppet, Long> {

    List<Puppet> findAllByOrderByScoreDesc ();
}
