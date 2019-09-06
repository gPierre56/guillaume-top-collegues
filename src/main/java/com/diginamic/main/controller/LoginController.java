/**
 * 
 */
package com.diginamic.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginamic.main.model.InfosAuthentification;

/**
 * @author Guillaume
 *
 */
@Controller
@RequestMapping(value = "/auth")
public class LoginController {

	@GetMapping
	public String login(Model model) {
		InfosAuthentification infos = new InfosAuthentification();
		model.addAttribute("infos", infos);
		return "authentification";

	}

}
