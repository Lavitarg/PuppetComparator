package com.example.demo.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class AppUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private boolean alreadyVoted;
    private Set<Role> roles;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean haveVoted;

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAlreadyVoted() {
        return alreadyVoted;
    }

    public void setAlreadyVoted(boolean alreadyVoted) {
        this.alreadyVoted = alreadyVoted;
    }

    public AppUser(String username, String password, boolean active, boolean alreadyVoted, Set<Role> roles, boolean haveVoted) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.alreadyVoted = alreadyVoted;
        this.roles = roles;
        this.haveVoted = haveVoted;
    }
}
