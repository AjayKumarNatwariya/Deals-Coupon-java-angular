package com.jwtuserauthentication.repository;

import com.jwtuserauthentication.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
