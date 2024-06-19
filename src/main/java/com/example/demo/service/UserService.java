package com.example.demo.service;

import com.example.demo.models.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public Users createUser(Users users){
        return usersRepository.save(users);
    }

    public Users findOne(String id){
        return usersRepository.findById(id).get();
    }

    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    }

    public Users updareuser(Users user){
        return usersRepository.save(user);
    }

    public String deleteuser(String id){
        usersRepository.deleteById(id);
        return "userDeleted";
    }


}
