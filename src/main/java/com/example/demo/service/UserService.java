package com.example.demo.service;
import com.example.demo.models.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;



    public Users createUser(Users users){
        return usersRepository.save(users);
    }

    public Optional<Users> findOne(String id){
        return Optional.of(usersRepository.findById(id).get());
    }

    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    }

    public Users updareuser(Users user){
        return usersRepository.save(user);
    }



    public String deleteuser(String id){
      usersRepository.deleteById(id);
      return null;
    }


}
