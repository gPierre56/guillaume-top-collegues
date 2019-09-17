/**
 * 
 */
package com.diginamic.main.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.main.dto.CollegueIdentifieDto;
import com.diginamic.main.model.InfosAuthentification;
import com.diginamic.main.repository.CollegueRepository;
import com.diginamic.main.service.CollegueService;

import io.jsonwebtoken.Jwts;

/**
 * @author Guillaume
 *
 */
@RestController
public class AuthentificationController {

	@Value("${jwt.expires_in}")
	private Integer EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Value("${jwt.secret}")
	private String SECRET;

	private CollegueRepository repository;

	private PasswordEncoder passwordEncoder;

	@Autowired
	private CollegueService service;

	public AuthentificationController(CollegueRepository repository, PasswordEncoder passwordEncoder) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping(value = "/auth")
	public ResponseEntity<?> authentificate(@RequestBody InfosAuthentification infos) {
		return this.repository.findByInfosConnexionUsername(infos.getNomUtilisateur())
				.filter(u -> passwordEncoder.matches(infos.getMotDePasse(), u.getInfosConnexion().getPassword()))
				.map(u -> {
					Map<String, Object> infosSupplementairesToken = new HashMap<>();
					infosSupplementairesToken.put("roles", u.getInfosConnexion().getRoles());

					String jetonJWT = Jwts.builder().setSubject(u.getInfosConnexion().getUsername())
							.addClaims(infosSupplementairesToken)
							.setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN * 1000))
							.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET).compact();

					ResponseCookie tokenCookie = ResponseCookie.from(TOKEN_COOKIE, jetonJWT).httpOnly(true)
							.maxAge(EXPIRES_IN * 1000).path("/").build();
					return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, tokenCookie.toString()).build();
				})

				.orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

//	@PostMapping(value = "/auth")
//	public ResponseEntity<?> authentificate(@RequestBody InfosAuthentification infos) {
//		return this.repository.findByInfosConnexionUsername(infos.getNomUtilisateur())
//				.filter(u -> passwordEncoder.matches(infos.getMotDePasse(), u.getInfosConnexion().getPassword()))
//				.map(u -> {
//					Map<String, Object> infosSupplementairesToken = new HashMap<>();
//					infosSupplementairesToken.put("roles", u.getInfosConnexion().getRoles());
//
//					String jetonJWT = Jwts.builder().setSubject(u.getInfosConnexion().getUsername())
//							.addClaims(infosSupplementairesToken)
//							.setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN * 1000))
//							.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET).compact();
//
//					ResponseCookie tokenCookie = ResponseCookie.from(TOKEN_COOKIE, jetonJWT).httpOnly(true)
//							.maxAge(EXPIRES_IN * 1000).path("/").build();
//					return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, tokenCookie.toString()).build();
//				})
//
//				.orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
//	}

	@GetMapping(value = "/auth/user")
	public ResponseEntity<CollegueIdentifieDto> getCollegueIdentifie() {
		return new ResponseEntity<>(service.recupererCollegueIdentifie(), HttpStatus.OK);
	}

}
