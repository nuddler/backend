package com.bdlugosz.fleeter.bff;

import com.bdlugosz.fleeter.bff.model.Teaser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeaserRepository extends MongoRepository<Teaser, String> {

}