package com.mural.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.mural.model.Vaga;



@Controller
public class VagaController {
	


	/*
	@GetMapping("")
	List<Vaga> all(){
		return vagaRepository.findAll();
	}*/
	
	@GetMapping("/")
	public String usuarios(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Vaga>> response =
				restTemplate.exchange(
						"https://wsemp02.herokuapp.com/", 
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<List<Vaga>>() { }
				);
		
		List<Vaga> lista = response.getBody();
		
		
		model.addAttribute("lista", lista);
		
		System.out.println(lista);
		
		return "index";
	}
	
}
