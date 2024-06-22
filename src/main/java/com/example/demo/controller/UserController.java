package com.example.demo.controller;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.models.Users;
import com.example.demo.service.UserService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Users> findOne(@PathVariable String id
    ){
        Optional<Users> users= userService.findOne(id);
        return users.map(ResponseEntity::ok).orElseGet(
                ()-> ResponseEntity.notFound().build()
        );
    }


    @GetMapping("/findall")
    public ResponseEntity<?> findAllUsers(){
        try {
            return ResponseEntity.ok(userService.findAllUsers());
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found");
        }
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
