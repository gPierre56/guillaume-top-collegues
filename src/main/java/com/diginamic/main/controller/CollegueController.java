/**
 *
 */
package com.diginamic.main.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.diginamic.main.dto.CollegueDto;
import com.diginamic.main.exception.CollegueInvalideException;
import com.diginamic.main.exception.CollegueNonTrouveException;
import com.diginamic.main.model.Collegue;
import com.diginamic.main.service.CollegueService;

/**
 * @author Guillaume Classe recevant les requêtes Http concernant les entités
 *         Collegue
 */
@RestController
@RequestMapping(value = "/collegue")
public class CollegueController {

    /**
     * Injection de la classe de service nécéssaire aux opérations de modification
     * de la classe collègue
     */
    @Autowired
    CollegueService service;

    /**
     * @param nomCollegue = Nom utilisé pour effectuer une recherche de collègue(s)
     *                    via leur nom de famille
     * @return un collègue ou une liste dont les noms de famille sont équivalent à
     *         celui recherché Fonctionne en GET
     */
    @GetMapping
    @ResponseBody
    public List<String> getCollegueByNom(@RequestParam String nomCollegue) {
        return service.rechercherParNom(nomCollegue).stream().map(collegue -> collegue.getMatricule())
                .collect(Collectors.toList());

    }

    /**
     * @param matricule = Matricule utilisé pour effectuer une recherche de collègue
     *                  via leur matricule unique
     * @return Retourne le collègue dont le matricule correspond à celui recherché.
     *         Si aucun matricule ne correspond, renvoie une exception. Fonctionne
     *         en GET
     */
    @GetMapping(value = "/{matricule}")
    public ResponseEntity<Collegue> getCollegueByMatricule(@PathVariable String matricule) {
        try {
            Collegue resultat = service.rechercherParMatricule(matricule);
            return new ResponseEntity<Collegue>(resultat, HttpStatus.OK);
        } catch (CollegueNonTrouveException e) {
            HttpHeaders header = new HttpHeaders();
            header.set("Erreur", "Collègue non trouvé");
            return new ResponseEntity<Collegue>(null, header, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @param c = Correspond au collègue que l'on souhaite ajouter en base de
     *          données récupérés puis parsé depuis un format JSON vaec une classe
     *          model de récupération (DTO)
     * @return Renvoie le collègue ajouté en base ou, si une erreur s'est produite,
     *         renvoie une exception. Fonctionne en POST
     */
    @PostMapping
    public ResponseEntity<Collegue> addCollegue(@RequestBody Collegue c) {
        HttpHeaders header = new HttpHeaders();
        try {
            header.set("Succes", "Succès");
            return new ResponseEntity<Collegue>(service.ajouterUnCollegue(c), header, HttpStatus.ACCEPTED);

        } catch (CollegueInvalideException e) {

            header.set("Erreur", e.getMsg());
            return new ResponseEntity<Collegue>(null, header, HttpStatus.CONFLICT);
        }
    }

    /**
     * @param matricule = Le matricule du collegue dont on souhaite modifier l'email
     *                  ou l'url photo
     * @param dto       = Classe de récupération des informatons du JSON renvoyé
     *                  pour formater les données en attribut d'un collègue
     * @return Renvoie une réponse HTTP avec le collègue modifié dans le corps et un
     *         code de succès ou d'échec
     */
    @PatchMapping(value = "/{matricule}")
    public ResponseEntity<Collegue> modifierCollegue(@PathVariable String matricule, @RequestBody CollegueDto dto) {

        try {
            HttpHeaders header = new HttpHeaders();
            if (dto.getEmail() != null && dto.getUrlPhoto() != null) {
                return new ResponseEntity<>(service.modifierPhotoEtEmail(matricule, dto.getUrlPhoto(), dto.getEmail()), header, HttpStatus.OK);
            }

            if (dto.getEmail() != null) {
                return new ResponseEntity<>(service.modifierEmail(matricule, dto.getEmail()), header, HttpStatus.OK);
            }
            if (dto.getUrlPhoto() != null) {
                return new ResponseEntity<>(service.modifierPhotoUrl(matricule, dto.getUrlPhoto()), header,
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(header, HttpStatus.OK);
        } catch (CollegueNonTrouveException e) {
            return ResponseEntity.notFound().header("Erreur", e.getMsg()).build();
        } catch (CollegueInvalideException e) {
            return ResponseEntity.badRequest().header("Erreur", e.getMsg()).build();
        }

    }

    @ExceptionHandler(value = {CollegueInvalideException.class})
    protected ResponseEntity<Object> handleConflict(CollegueInvalideException ex, WebRequest request) {
        String bodyOfResponse = ex.getMsg();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(bodyOfResponse);
    }

    @ExceptionHandler(value = {CollegueNonTrouveException.class})
    protected ResponseEntity<Object> handleConflict(CollegueNonTrouveException ex, WebRequest request) {
        String bodyOfResponse = ex.getMsg();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(bodyOfResponse);
    }

}
