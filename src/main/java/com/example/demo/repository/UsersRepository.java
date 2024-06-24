package com.example.demo.repository;

import com.example.demo.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UsersRepository extends MongoRepository<Users, String> {
}
