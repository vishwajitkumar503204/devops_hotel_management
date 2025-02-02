package com.example.hotel_management.service;

import com.example.hotel_management.model.Guest;
import com.example.hotel_management.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(String id) {
        return guestRepository.findById(id);
    }

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void deleteGuest(String id) {
        guestRepository.deleteById(id);
    }

    public Guest updateGuest(String id, Guest guestDetails) {
        Optional<Guest> guest = guestRepository.findById(id);

        if (guest.isPresent()) {
            Guest existingGuest = guest.get();
            existingGuest.setName(guestDetails.getName());
            existingGuest.setEmail(guestDetails.getEmail());
            existingGuest.setPhoneNumber(guestDetails.getPhoneNumber());
            existingGuest.setAddress(guestDetails.getAddress());
            return guestRepository.save(existingGuest);
        } else {
            return null;
        }
    }
}
