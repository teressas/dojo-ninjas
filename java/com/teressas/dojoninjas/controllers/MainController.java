package com.teressas.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.teressas.dojoninjas.models.Dojo;
import com.teressas.dojoninjas.models.Ninja;
import com.teressas.dojoninjas.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo newDojo) {
		return "createDojoForm.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String processDojoForm(@Valid @ModelAttribute("newDojo") Dojo newDojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "createDojoForm.jsp";
		} else {
			mainService.saveDojo(newDojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja newNinja, Model model) {
		List<Dojo> dojos = mainService.allDojos();
		model.addAttribute("dojos", dojos);
		return "createNinjaForm.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String processNinjaForm(@Valid @ModelAttribute("newNinja") Ninja newNinja,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = mainService.allDojos();
			model.addAttribute("dojos", dojos);
			return "createNinjaForm.jsp";
		} else {
			mainService.saveNinja(newNinja);
			return "redirect:/ninjas/new";
		}
		
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String findOneDojo(@PathVariable("dojoId") Long id, Model model) {
		Dojo dojo = mainService.findOneDojo(id);
		model.addAttribute("dojo", dojo);
		return "showNinjasLocation.jsp";
	}
	
	

}
