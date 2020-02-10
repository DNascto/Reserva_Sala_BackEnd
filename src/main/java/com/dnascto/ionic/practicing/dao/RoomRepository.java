package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
//public interface RoomRepository extends MongoRepository<Room, String>  {
public interface RoomRepository extends JpaRepository<Room, String> {

    @Query("SELECT r FROM Room r WHERE r.name = :name")
    List<Room> findByName(@Param("name") String name);

    @Query("SELECT COUNT(r) FROM Room r WHERE r.booked = :book")
    Long countByBooked(@Param("book") Boolean booked);

    @Query("SELECT r FROM Room r ")//WHERE r.booked = false")
    List<Room> findNoBookedRooms();
}
