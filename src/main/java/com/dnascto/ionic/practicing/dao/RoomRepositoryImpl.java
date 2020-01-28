package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoomRepositoryImpl {
    @Autowired
    private RoomRepository roomRepository;

    public Optional<Room> findById(int id){
        return roomRepository.findById(String.valueOf(id));
    }

    public List<Room> getAllRoom(){
        return roomRepository.findAll();
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

}
