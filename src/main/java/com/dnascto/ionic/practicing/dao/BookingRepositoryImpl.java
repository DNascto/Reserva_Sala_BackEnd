package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Booking;
import com.dnascto.ionic.practicing.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BookingRepositoryImpl {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking findById(int id){
        return bookingRepository.getOne(String.valueOf(id));
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public List<Booking> findByApprove(Boolean approved){
        return bookingRepository.findByApproved(approved, LocalDateTime.now());
    }

    public List<Booking> findByAuthor(String authorName){
        return bookingRepository.findByAuthor(authorName);
    }

    public Booking addBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }
}
