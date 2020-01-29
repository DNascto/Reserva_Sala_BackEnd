package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Booking;
import com.dnascto.ionic.practicing.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookingRepositoryImpl {
    @Autowired
    private BookingRepository bookingRepository;

    public Optional<Booking> findById(int id){
        return bookingRepository.findById(String.valueOf(id));
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking addBooking(Booking booking){
        return bookingRepository.save(booking);
    }

}
