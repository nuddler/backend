package com.bdlugosz.fleeter.bff.repository;

import com.bdlugosz.fleeter.bff.model.Car;
import com.bdlugosz.fleeter.bff.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
