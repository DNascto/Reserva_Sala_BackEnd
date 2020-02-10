package com.dnascto.ionic.practicing.service;

import com.dnascto.ionic.practicing.dao.BookingRepositoryImpl;
import com.dnascto.ionic.practicing.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BookingService {
    private BookingRepositoryImpl bookingRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    public BookingService(BookingRepositoryImpl bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking findById(int id){
        return bookingRepository.findById(id);
    }

    public List<Booking> getAllBooking(){
        return bookingRepository.getAllBookings();
    }

    public List<Booking> findByApprove(Boolean approved){
        return bookingRepository.findByApprove(approved);
    }

    public List<Booking> findByAuthor(String authorName){
        return bookingRepository.findByAuthor(authorName);
    }

    public Booking newBooking(Booking booking){
        if(booking.getApproved()){
//            Room room = roomService.getRoom(booking.getRoom().getId());
            booking.getRoom().setBooked(true);
            roomService.updateRoom(booking.getRoom());
        }
        booking.setDate(LocalDateTime.of(booking.getDate().getYear(),booking.getDate().getMonth(),
                booking.getDate().getDayOfMonth(), booking.getDate().getHour(),booking.getDate().getMinute()));
        return bookingRepository.addBooking(booking);
    }

    public Booking updateBooking(Booking booking){
        return bookingRepository.updateBooking(booking);
    }

}
