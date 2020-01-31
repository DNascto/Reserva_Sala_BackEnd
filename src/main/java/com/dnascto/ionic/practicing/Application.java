package com.dnascto.ionic.practicing;

import com.dnascto.ionic.practicing.dao.BookingRepository;
import com.dnascto.ionic.practicing.dao.RoomRepository;
import com.dnascto.ionic.practicing.model.Booking;
import com.dnascto.ionic.practicing.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;
//	@Autowired
//	private RoomRepositoryMongo roomRepositoryMongo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private static final Logger LOG = LoggerFactory.getLogger("dnascto");

    @Override
    public void run(String... args) throws Exception {
        List<Room> roomList = Arrays.asList(
                new Room[]{
                        new Room(1, "Sala 1", 15, true, false),
                        new Room(2, "Sala 2", 5, false, false),
                        new Room(3, "Sala 3", 45, true, false),
                        new Room(4, "Sala 4", 10, false, false)
                });
        roomRepository.save(roomList.get(0));
        roomRepository.save(roomList.get(1));
        roomRepository.save(roomList.get(2));
        roomRepository.save(roomList.get(3));

        bookingRepository.save(new Booking(1, LocalDateTime.of(2019, 1, 1, 12, 0),
				roomList.get(0), 2, "Bill Zuck"));
        bookingRepository.save(new Booking(2, LocalDateTime.of(2020, 2, 1, 14, 0),
				roomList.get(1), 1, "Mark Jobs"));
        bookingRepository.save(new Booking(3, LocalDateTime.of(2020, 1, 6, 12, 0),
				roomList.get(2), 5, "Steve Gates"));
//        bookingRepository.save(new Booking(4, LocalDateTime.now(), roomList.get(3), 5, "Linux Mouse"));

//		LOG.info("Getting all data from MongoDB: \n{}",
//				repository.findAll());
//		LOG.info("Getting by ID data from MongoDB: \n{}",
//				repository.findById("1"));

    }
}
