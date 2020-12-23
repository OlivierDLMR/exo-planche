package exo.planche.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import exo.planche.Application.PlancheService;

@RestController
public class PlancheController {
	
	@Autowired
	PlancheService service;
	
	@PostMapping("/calcul/{surface}")
	public void calculerNombrePlanche(@PathVariable double surface) {
		service.calculerNombrePlanche(surface);
		
	}
	
	

}
