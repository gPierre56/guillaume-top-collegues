/**
 * 
 */
package com.diginamic.main.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.main.exception.CollegueInvalideException;
import com.diginamic.main.exception.CollegueNonTrouveException;
import com.diginamic.main.model.Collegue;
import com.diginamic.main.repository.CollegueRepository;
import com.diginamic.main.utils.CollegueValidator;

/**
 * @author Guillaume
 *
 */

@Service
public class CollegueService {

	@Autowired
	private CollegueValidator validator;

	@Autowired
	private CollegueRepository repository;

	public List<Collegue> rechercherParNom(String nom) {

		return repository.findByNom(nom);

	}

	public Collegue rechercherParMatricule(String matriculeRecherche) throws CollegueNonTrouveException {

		Optional<Collegue> resultat = repository.findById(matriculeRecherche);

		if (!resultat.isPresent()) {
			throw new CollegueNonTrouveException("Aucun résultat pour ce matricule");
		} else {
			return resultat.get();
		}

	}

	public Collegue ajouterUnCollegue(Collegue c) throws CollegueInvalideException {
		if (validator.validerTout(c)) {
			c.setMatricule(UUID.randomUUID().toString());
			repository.save(c);
			return c;
		} else {
			throw new CollegueInvalideException(
					"L'un des champs renseigné pour la création d'un collègue est invalide, merci de vérifier");
		}

	}

	@Transactional
	public Collegue modifierEmail(String matricule, String email)
			throws CollegueNonTrouveException, CollegueInvalideException {
		Collegue c = rechercherParMatricule(matricule);
		if (validator.validerEmail(email)) {
			c.setEmail(email);
			return c;
		} else {
			throw new CollegueInvalideException("Modification invalide");
		}
	}

	@Transactional
	public Collegue modifierPhotoUrl(String matricule, String url)
			throws CollegueNonTrouveException, CollegueInvalideException {
		Collegue c = rechercherParMatricule(matricule);
		if (validator.validerUrlPhoto(url)) {
			c.setPhotoUrl(url);
			return c;
		} else {
			throw new CollegueInvalideException("Modification invalide, veuillez vérifier");
		}
	}

}
