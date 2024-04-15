package com.foliole.gent;

import com.foliole.gent.models.FieldDetails;
import com.foliole.gent.service.CSVReaderService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j
public class GentApplication implements CommandLineRunner {

	@Autowired
	private CSVReaderService service;

	public static void main(String[] args) {
		SpringApplication.run(GentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sanitizeArgs(args);
		service.read("/Users/atdey/Desktop/test.csv", 0, FieldDetails.class).forEach(System.out::println);
	}

	private void sanitizeArgs(String... args) {
		log.info("Sanitizing arguments...");
	}
}
