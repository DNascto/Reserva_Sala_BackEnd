package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomRepositoryImpl {
    @Autowired
    private RoomRepository roomRepository;

    public Room findById(int id){
        return roomRepository.getOne(String.valueOf(id));
    }

    public List<Room> getAllRoom(){
        return roomRepository.findAll();
    }

    public List<Room> getAllFreeRoom(){
        return roomRepository.findNoBookedRooms();
    }

    public Long getCountBookedRoom(Boolean booked){
        return roomRepository.countByBooked(booked);
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room){
        return roomRepository.save(room);
    }

}
