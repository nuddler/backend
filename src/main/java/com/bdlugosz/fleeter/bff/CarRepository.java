package com.bdlugosz.fleeter.bff;

import com.bdlugosz.fleeter.bff.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {

}
