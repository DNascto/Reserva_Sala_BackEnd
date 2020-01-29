package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
//public interface BookingRepository extends MongoRepository<Booking, String>  {
public interface BookingRepository extends JpaRepository<Booking, String> {
//    public List<Booking> findByName(String name);
}
