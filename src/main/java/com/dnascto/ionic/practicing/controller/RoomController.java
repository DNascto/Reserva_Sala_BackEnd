package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.model.Room;
import com.dnascto.ionic.practicing.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomService service;

    public RoomController() {}

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping("/room")
    public Room getRoom(@RequestParam int id){
        return service.getRoom(id);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return service.getAllRoom();
    }

//    @PostMapping("/room")
//    public Room postNewRoom(@RequestBody Room room){
//        return service.newRoom(room);
//    }

}
