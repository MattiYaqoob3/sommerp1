package com.example.demo.controller;

import com.example.demo.dto.CreateUserDTO;
import com.example.demo.models.Users;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/add")
    public CreateUserDTO createUser(@RequestBody CreateUserDTO createUserDTO){
        return userService.createUser(createUserDTO);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findOne(@PathVariable String id)
    {
       try {
           return ResponseEntity.ok(userService.findOne(id));
       }catch (NoSuchElementException e){// This NoSuchElementException is for if the user is not exist
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found");
       }
    }


    @GetMapping("/findall")
    public ResponseEntity<?> findAllUsers(){
      return ResponseEntity.ok(userService.findAllUsers());
    }

    @PutMapping ("/update/{id}")
    public Users updareuser(@RequestBody Users users,
                            @PathVariable("id")String _id){
        return userService.updareuser(users);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteuser(@PathVariable String id){
        try {
            return ResponseEntity.ok(userService.deleteuser(id));
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not user exist");
        }
    }






}
