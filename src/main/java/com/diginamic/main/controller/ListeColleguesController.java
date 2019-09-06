/**
 * 
 */
package com.diginamic.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diginamic.main.model.Collegue;
import com.diginamic.main.repository.CollegueRepository;

/**
 * @author Guillaume
 *
 */
@Controller
public class ListeColleguesController {

	@Autowired
	CollegueRepository repository;

	@GetMapping(value = "/liste_collegues")
	public ModelAndView listeCollegues() {
		ModelAndView mav = new ModelAndView();
		List<Collegue> collegues = repository.findAll();
		mav.addObject("collegue", collegues);
		mav.setViewName("liste_collegues");
		return mav;
	}

}
