package com.badal.rest.webservices.restfulwebservices.Controller;

import com.badal.rest.webservices.restfulwebservices.Entity.User;
import com.badal.rest.webservices.restfulwebservices.Service.UserDaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service){
        this.service = service;
    }
    @GetMapping(path = "/users")
    public List<User> retrieveAllUser(){
        return service.findAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
    return service.findOne(id);
    }

    @PostMapping ("/users")
    public User createUser(@RequestBody User user){
        return service.save(user);
    }
}
