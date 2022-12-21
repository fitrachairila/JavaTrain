package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.Passengers;

public interface PassengersRepo extends MongoRepository<Passengers, String> {

}
