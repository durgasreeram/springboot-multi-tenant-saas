package com.Saas.project.controller;

import com.Saas.project.entity.User;
import com.Saas.project.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepo userRepo;

    public UserController (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);

        }
    }



