/**
 * 
 */
package com.diginamic.main.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.diginamic.main.exception.CollegueInvalideException;
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

		List<Collegue> resultat = this.data.values().stream()
				.filter(collegue -> collegue.getMatricule().equals(matriculeRecherche)).collect(Collectors.toList());

		if (resultat.isEmpty()) {
			throw new CollegueNonTrouveException("Aucun résultat pour ce matricule");
		} else {
			return resultat.get(0);
		}

	}

	public Collegue ajouterUnCollegue(Collegue c) throws CollegueInvalideException {
		if (c.getNom().length() > 1 && c.getPrenom().length() > 1
				&& (c.getEmail().contains("@") && c.getEmail().length() > 2) && c.getPhotoUrl().startsWith("http")
				&& (Period.between(c.getDateDeNaissance(), LocalDate.now()).getYears() > 17)) {
			c.setMatricule(UUID.randomUUID().toString());
			this.data.put(c.getMatricule(), c);
			return c;
		} else {
			throw new CollegueInvalideException(
					"L'un des champs renseigné pour la création d'un collègue est invalide, merci de vérifier");
		}

	}

	public Collegue modifierEmail(String matricule, String email)
			throws CollegueNonTrouveException, CollegueInvalideException {
		Collegue c = rechercherParMatricule(matricule);
		if (email.contains("@") && email.length() > 2) {
			c.setEmail(email);
			return c;
		} else {
			throw new CollegueInvalideException("Modification invalide");
		}
	}

	public Collegue modifierPhotoUrl(String matricule, String url)
			throws CollegueNonTrouveException, CollegueInvalideException {
		Collegue c = rechercherParMatricule(matricule);
		if (url.startsWith("http")) {
			c.setPhotoUrl(url);
			return c;
		} else {
			throw new CollegueInvalideException("Modification invalide, veuillez vérifier");
		}
	}

	/**
	 * @return the data
	 */
	public Map<String, Collegue> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Collegue> data) {
		this.data = data;
	}

}
