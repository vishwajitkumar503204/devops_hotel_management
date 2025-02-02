package com.example.hotel_management.service;

import com.example.hotel_management.model.Room;
import com.example.hotel_management.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRoomsByHotel(String hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
}
