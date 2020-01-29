package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Room;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface RoomRepositoryMongo {
    public Room findByName(String name);
}
