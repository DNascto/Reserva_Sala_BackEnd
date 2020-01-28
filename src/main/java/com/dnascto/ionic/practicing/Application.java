package com.dnascto.ionic.practicing;

import com.dnascto.ionic.practicing.dao.RoomRepository;
import com.dnascto.ionic.practicing.dao.RoomRepositoryMongo;
import com.dnascto.ionic.practicing.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class Application implements CommandLineRunner {

	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RoomRepositoryMongo roomRepositoryMongo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private static final Logger LOG = LoggerFactory.getLogger("dnascto");



	@Override
	public void run(String... args) {
		roomRepository.save(new Room(1, "Sala 1", 15, true, false));
		roomRepository.save(new Room(2, "Sala 2", 5, false, false));

		LOG.info("Getting all data from MongoDB: \n{}",
				roomRepository.findAll());
		LOG.info("Getting by ID data from MongoDB: \n{}",
				roomRepository.findById("1"));

	}
}
