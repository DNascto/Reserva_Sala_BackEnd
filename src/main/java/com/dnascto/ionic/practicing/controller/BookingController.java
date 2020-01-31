package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.model.Booking;
import com.dnascto.ionic.practicing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class BookingController {
    @Autowired
    private BookingService service;

    public BookingController() {}

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping("/booking")
    public Booking getRoom(@RequestParam int id){
        return service.getBooking(id);
    }

    @GetMapping("/bookings")
    public List<Booking> getAllRooms(){
        return service.getAllBooking();
    }

    @PostMapping("/booking")
    public Booking postNewRoom(@RequestBody Booking booking){
        return service.newBooking(booking);
    }

}
