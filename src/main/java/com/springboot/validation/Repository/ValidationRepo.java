package com.springboot.validation.Repository;

import com.springboot.validation.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ValidationRepo extends MongoRepository<User, String> {

    public  Optional<User> findByEmail(String email);

    public long deleteByEmail(String email);

    public boolean existsByEmail(String email);



}
