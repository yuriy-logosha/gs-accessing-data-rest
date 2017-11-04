package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	private final PersonRepository personRepository;

	@Autowired
	public Application(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		// save a couple of books
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Iurii", "Logosha"));
		persons.add(new Person("Omar", "Epps"));
		persons.add(new Person("Dr.", "House"));
		personRepository.save(persons);

		// fetch all persons
		for (Person person : personRepository.findAll()) {
			logger.info(person.toString());
		}
	}
}
