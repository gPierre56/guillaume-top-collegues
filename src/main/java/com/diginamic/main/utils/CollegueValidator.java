/**
 * 
 */
package com.diginamic.main.utils;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.diginamic.main.model.Collegue;

/**
 * @author Guillaume
 *
 */
@Component
public class CollegueValidator {

	public Boolean validerNom(String nom) {
		return (nom.length() > 1);
	}

	public Boolean validerPrenom(String prenom) {
		return (prenom.length() > 2);
	}

	public Boolean validerEmail(String email) {
		return (email.contains("@") && email.length() > 2);
	}

	public Boolean validerAge(LocalDate dateDeNaissance) {
		return (Period.between(dateDeNaissance, LocalDate.now()).getYears() > 17);
	}

	public Boolean validerUrlPhoto(String url) {
		return (url.startsWith("http"));
	}

	public Boolean validerTout(Collegue c) {
		return (validerNom(c.getNom()) && validerPrenom(c.getPrenom()) && validerEmail(c.getEmail())
				&& validerAge(c.getDateDeNaissance()) && validerUrlPhoto(c.getPhotoUrl()));
	}

}
