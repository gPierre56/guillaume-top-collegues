/**
 * 
 */
package com.diginamic.main.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.diginamic.main.exception.CollegueNonTrouveException;
import com.diginamic.main.model.Collegue;

/**
 * @author Guillaume
 *
 */
public class CollegueService {

	private Map<String, Collegue> data = new HashMap<>();

	public CollegueService() {
		String matricule1 = UUID.randomUUID().toString();
		String matricule2 = UUID.randomUUID().toString();
		String matricule3 = UUID.randomUUID().toString();
		this.data.put(matricule1, new Collegue(matricule1.toString(), "Pierre", "Guillaume", "ergreg@gmail.com",
				LocalDate.of(1991, 9, 20), "http://www.nioutaik.fr/images/galerie/hackerstr.jpg"));
		this.data.put(matricule2, new Collegue(matricule2, "Turpin", "Eloi", "test@gmail.com",
				LocalDate.of(1978, 2, 14), "http://www.nioutaik.fr/images/galerie/falcon-punch.jpg"));
		this.data.put(matricule3, new Collegue(matricule3, "Peyras", "Cécile", "test@gmail.fr",
				LocalDate.of(1980, 7, 15), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg"));
	}

	public List<Collegue> rechercherParNom(String nom) {
		List<Collegue> resultat;
		resultat = this.data.values().stream().filter(collegue -> collegue.getNom().equals(nom))
				.collect(Collectors.toList());
		return resultat;
	}
	
	public Collegue rechercherParMatricule(String matriculeRecherche) throws CollegueNonTrouveException {
        
		List<Collegue> resultat = this.data.values().stream().filter(collegue -> collegue.getMatricule().equals(matriculeRecherche))
				.collect(Collectors.toList());
		
		if (resultat.isEmpty()) {
			throw new CollegueNonTrouveException("Aucun résultat pour ce matricule");
		} else {
			return resultat.get(0);
		}
		
    }

}
