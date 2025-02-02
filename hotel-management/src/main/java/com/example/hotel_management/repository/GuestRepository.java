package com.example.hotel_management.repository;

import com.example.hotel_management.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRepository extends MongoRepository<Guest, String> {
    // Custom query methods can be defined here if needed
}
