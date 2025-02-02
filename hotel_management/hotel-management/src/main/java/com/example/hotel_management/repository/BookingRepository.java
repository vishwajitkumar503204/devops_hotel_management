package com.example.hotel_management.repository;

import com.example.hotel_management.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

    // Custom query to find bookings by customer name
    List<Booking> findByCustomerName(String customerName);

    // Custom query to find bookings by hotel name
    List<Booking> findByHotelName(String hotelName);
}
