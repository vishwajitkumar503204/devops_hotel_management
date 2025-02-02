package com.example.hotel_management.controller;

import com.example.hotel_management.model.Room;
import com.example.hotel_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/{hotelId}")
    public List<Room> getRoomsByHotel(@PathVariable String hotelId) {
        return roomService.getRoomsByHotel(hotelId);
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }
}
