package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
//public interface RoomRepository extends MongoRepository<Room, String>  {
public interface RoomRepository extends JpaRepository<Room, String> {
    public List<Room> findByName(String name);
}
