package com.example.demo.Repository;

import com.example.demo.Entities.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByUsername(String username);

}
