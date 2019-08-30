/**
 * 
 */
package com.diginamic.main.utils;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.diginamic.main.model.Collegue;

/**
 * @author Guillaume
 *
 */
@Component
public class DataUtils {

	public void fillMapCollegue(Map<String, Collegue> map) {

		String matricule1 = UUID.randomUUID().toString();
		String matricule2 = UUID.randomUUID().toString();
		String matricule3 = UUID.randomUUID().toString();
		map.put(matricule1, new Collegue(matricule1.toString(), "Pierre", "Guillaume", "ergreg@gmail.com",
				LocalDate.of(1991, 9, 20), "http://www.nioutaik.fr/images/galerie/hackerstr.jpg"));
		map.put(matricule2, new Collegue(matricule2, "Turpin", "Eloi", "test@gmail.com", LocalDate.of(1978, 2, 14),
				"http://www.nioutaik.fr/images/galerie/falcon-punch.jpg"));
		map.put(matricule3, new Collegue(matricule3, "Peyras", "Cécile", "test@gmail.fr", LocalDate.of(1980, 7, 15),
				"http://www.nioutaik.fr/images/galerie/fail%2002.jpg"));
	}

}
