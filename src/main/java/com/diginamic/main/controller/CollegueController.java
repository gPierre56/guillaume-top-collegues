/**
 * 
 */
package com.diginamic.main.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.main.service.CollegueService;

/**
 * @author Guillaume
 *
 */
@RestController
@RequestMapping(value = "/collegue")
public class CollegueController {

	CollegueService service = new CollegueService();

	@GetMapping
	@ResponseBody
	public List<String> getCollegueByNom(@RequestParam String nomCollegue) {
		return service.rechercherParNom(nomCollegue).stream().map(collegue -> collegue.getMatricule())
				.collect(Collectors.toList());

	}

}
