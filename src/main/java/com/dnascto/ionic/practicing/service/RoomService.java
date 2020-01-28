package com.dnascto.ionic.practicing.service;

import com.dnascto.ionic.practicing.dao.RoomRepositoryImpl;
import com.dnascto.ionic.practicing.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepositoryImpl roomRepositoryImpl;

    public Room getRoom(int id){
        Optional<Room> room = roomRepositoryImpl.findById(id);
        if(room.isPresent())
            return room.get();
        else{
            try {
                throw new Exception("Nenhuma sala encontrada.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Room();
    }

    public List<Room> getAllRoom(){
        return roomRepositoryImpl.getAllRoom();
    }

    public Room newRoom(Room room){
        return roomRepositoryImpl.addRoom(room);
    }

}
