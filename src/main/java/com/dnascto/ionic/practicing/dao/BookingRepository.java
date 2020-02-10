package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
//public interface BookingRepository extends MongoRepository<Booking, String>  {
public interface BookingRepository extends JpaRepository<Booking, String> {

//    @Query("SELECT b FROM Booking b WHERE b.approved = :app")
//    List<Booking> findByApproved(@Param("app") Boolean approved);
    @Query("SELECT b FROM Booking b WHERE b.approved = :app and b.date >= :day")
    List<Booking> findByApproved(@Param("app") Boolean approved, @Param("day") LocalDateTime day);

    @Query("SELECT b FROM Booking b WHERE b.author = :name")
    List<Booking> findByAuthor(@Param("name") String authorName);
}
