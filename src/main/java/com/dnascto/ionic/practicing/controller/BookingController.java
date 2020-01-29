package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.model.Booking;
import com.dnascto.ionic.practicing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
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
