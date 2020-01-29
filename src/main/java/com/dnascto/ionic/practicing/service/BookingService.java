package com.dnascto.ionic.practicing.service;

import com.dnascto.ionic.practicing.dao.BookingRepository;
import com.dnascto.ionic.practicing.dao.BookingRepositoryImpl;
import com.dnascto.ionic.practicing.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class BookingService {
    @Autowired
    private BookingRepositoryImpl bookingRepository;

    public Booking getBooking(int id){
        Optional<Booking> room = bookingRepository.findById(id);
        if(room.isPresent())
            return room.get();
        else{
            try {
                throw new Exception("Nenhuma sala encontrada.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Booking();
    }

    public List<Booking> getAllBooking(){
        return bookingRepository.getAllBookings();
    }

    public Booking newBooking(Booking booking){
        return bookingRepository.addBooking(booking);
    }

}
