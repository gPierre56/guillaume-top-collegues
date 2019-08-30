/**
 * 
 */
package com.diginamic.main.utils;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.diginamic.main.model.Collegue;
import com.diginamic.main.repository.CollegueRepository;

/**
 * @author Guillaume
 *
 */
@Component
public class StartupDataInit {

	@Autowired
	private CollegueRepository repository;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {
		String matricule1 = UUID.randomUUID().toString();
		String matricule2 = UUID.randomUUID().toString();
		String matricule3 = UUID.randomUUID().toString();
		repository.save(new Collegue(matricule1, "Pierre", "Guillaume", "ergreg@gmail.com", LocalDate.of(1991, 9, 20),
				"http://www.nioutaik.fr/images/galerie/hackerstr.jpg"));
		repository.save(new Collegue(matricule2, "Turpin", "Eloi", "test@gmail.com", LocalDate.of(1978, 2, 14),
				"http://www.nioutaik.fr/images/galerie/falcon-punch.jpg"));
		repository.save(new Collegue(matricule3, "Peyras", "Cécile", "test@gmail.fr", LocalDate.of(1980, 7, 15),
				"http://www.nioutaik.fr/images/galerie/fail%2002.jpg"));
	}

}
