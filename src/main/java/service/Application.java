package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.domain.Person;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static final int MAX_POSSIBLE_AMOUNT = 2000;

    public static final double INTEREST_FACTOR_PER_WEEK = 1.5;

    public static final double INTEREST = 0.5;

    @Autowired
    private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("170483-18001"));
        persons.add(new Person("100480-10001"));
        personRepository.save(persons);

    }

}
