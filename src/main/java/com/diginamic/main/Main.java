package com.diginamic.main;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.diginamic.main.model.Collegue;
import com.diginamic.main.model.InfosConnexion;
import com.diginamic.main.model.Role;
import com.diginamic.main.repository.CollegueRepository;

/**
 * @author Guillaume Point d'entrée de l'application
 */
@SpringBootApplication
public class Main {

	@Autowired
	private CollegueRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {
		repository.save(new Collegue("AZERTY", "Doe", "John", "john.doe@gmail.com", LocalDate.of(1989, 1, 31),
				"http://osef", new InfosConnexion("john", passwordEncoder.encode("1234"),
						Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_USER))));

		repository.save(
				new Collegue("QWERTY", "Duff", "John", "john.duff@gmail.com", LocalDate.of(1970, 1, 31), "http://osef",
						new InfosConnexion("jojo", passwordEncoder.encode("1234"), Arrays.asList(Role.ROLE_USER))));
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

}
