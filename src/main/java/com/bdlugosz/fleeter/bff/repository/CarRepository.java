package com.bdlugosz.fleeter.bff.repository;

import com.bdlugosz.fleeter.bff.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findAllByTakenIsFalse();
    List<Car> findAllByTakenBy(String uid);

}
