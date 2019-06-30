package com.example.demo.Services;

import com.example.demo.Entities.AppUser;
import java.security.Principal;

public interface AppUserService {

    boolean saveUniqUser(AppUser user);
    boolean getUserVoteStatus(Principal principal);
    void setUserVoted(Principal principal);

}
