package com.dnascto.ionic.practicing;

import com.dnascto.ionic.practicing.dao.BookingRepository;
import com.dnascto.ionic.practicing.dao.RoomRepository;
import com.dnascto.ionic.practicing.dao.UserRepository;
import com.dnascto.ionic.practicing.model.Booking;
import com.dnascto.ionic.practicing.model.Room;
import com.dnascto.ionic.practicing.model.User;
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

    @Autowired
    private UserRepository userRepository;

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
        for (int i = 0; i <= 10; i++) {
            roomRepository.save(new Room(i, "Sala "+i, 10, false, false));
        }

        bookingRepository.save(new Booking(1, LocalDateTime.now(), roomList.get(3), 60, "Linux Mouse", false));
//        userRepository.save(new User(1, "Daniel Rodrigues", "d","09876543211", "d","TCS", 4, true));
//        userRepository.save(new User(3, "Daniel Nascimento", "n","09876543212", "n","TCS", 1, true));
        userRepository.save(new User(1, "Daniel Rodrigues", "d","09876543211", "d",4, false));
        userRepository.save(new User(3, "Daniel Nascimento", "a","09876543212", "a", 1, true));
    }
}
