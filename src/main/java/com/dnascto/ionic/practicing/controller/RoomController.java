package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.model.Room;
import com.dnascto.ionic.practicing.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
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
    public List<Room> getAllFreeRooms(){
        return service.getAllFreeRoom();
    }

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return service.getAllRoom();
    }

    @PostMapping("/room")
    public Room postNewRoom(@RequestBody Room room){
        return service.newRoom(room);
    }

}
