package com.example.demo.controller;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.models.Users;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/add")
    public Users createUser(@RequestBody Users users){
        return userService.createUser(users);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<?>findOne(@PathVariable String id){
        try {
               return ResponseEntity.ok(userService.findOne(id));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }


    @GetMapping("/findall")
    public List<Users> findAllUsers(){
        return userService.findAllUsers();
    }

    @PutMapping ("/update/{id}")
    public Users updareuser(@RequestBody Users users,
                            @PathVariable("id")String _id){
        return userService.updareuser(users);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable String id){
        return userService.deleteuser(id);
    }






}
