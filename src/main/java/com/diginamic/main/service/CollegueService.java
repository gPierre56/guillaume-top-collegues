/**
 *
 */
package com.diginamic.main.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import com.diginamic.main.dto.MatriculePhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.diginamic.main.dto.CollegueIdentifieDto;
import com.diginamic.main.exception.CollegueInvalideException;
import com.diginamic.main.exception.CollegueNonTrouveException;
import com.diginamic.main.model.Collegue;
import com.diginamic.main.repository.CollegueRepository;
import com.diginamic.main.utils.CollegueValidator;
import org.springframework.web.bind.annotation.GetMapping;

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

    public Collegue rechercherParEmail(String email) {
        Optional<Collegue> resultat = repository.findByEmail(email);
        if (!resultat.isPresent()) {
            return null;
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

    @Transactional
    public Collegue modifierPhotoEtEmail(String matricule, String url, String email) throws CollegueNonTrouveException, CollegueInvalideException {
        Collegue c = rechercherParMatricule(matricule);
        if (validator.validerEmail(email)) {
            c.setEmail(email);
        } else {
            throw new CollegueInvalideException("Modification invalide, veuillez vérifier");
        }
        if (validator.validerUrlPhoto(url)) {
            c.setPhotoUrl(url);
            return c;
        } else {
            throw new CollegueInvalideException("Modification invalide, veuillez vérifier");
        }


    }

    public CollegueIdentifieDto recupererCollegueIdentifie() {
        Optional<Collegue> collegue = repository
                .findByInfosConnexionUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (collegue.isPresent()) {
            return Stream.of(collegue.get()).map(c -> new CollegueIdentifieDto(c.getMatricule(), c.getNom(),
                    c.getPrenom(), c.getInfosConnexion().getRoles())).collect(Collectors.toList()).get(0);
        } else {
            return null;
        }
    }


    public List<MatriculePhotoDto> recupererToutesLesPhotos() {

        return repository.findAll().stream().filter(c -> c.getPhotoUrl() != null).map(c -> new MatriculePhotoDto(c.getMatricule(), c.getPhotoUrl())).collect(Collectors.toList());
    }

}
