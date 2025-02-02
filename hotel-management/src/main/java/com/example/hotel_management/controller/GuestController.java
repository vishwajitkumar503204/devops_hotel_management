package com.example.hotel_management.controller;

import com.example.hotel_management.model.Guest;
import com.example.hotel_management.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    // Get all guests
    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    // Get guest by ID
    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable String id) {
        Optional<Guest> guest = guestService.getGuestById(id);
        return guest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new guest
    @PostMapping
    public Guest addGuest(@RequestBody Guest guest) {
        return guestService.addGuest(guest);
    }

    // Delete a guest by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable String id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }

    // Update an existing guest
    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable String id, @RequestBody Guest guestDetails) {
        Guest updatedGuest = guestService.updateGuest(id, guestDetails);
        return updatedGuest != null ? ResponseEntity.ok(updatedGuest) : ResponseEntity.notFound().build();
    }
}
