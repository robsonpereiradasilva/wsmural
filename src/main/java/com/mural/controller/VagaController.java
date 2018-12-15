package com.mural.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

 
import com.mural.model.Vaga;
import com.mural.repository.VagaRepository;



@Controller
public class VagaController {
		

	/*
	 * Médodo substituido
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
		
		
		
		return "index";
	}
	*/
	
	@GetMapping("/")
	public String vagas (Model model) {
		ResponseEntity <List<Vaga>> response;
		response = this.method("https://wsemp02.herokuapp.com");
		List<Vaga> lista = response.getBody();
		
		response = this.method("https://wsmural.herokuapp.com/vagas");
		
		List<Vaga> lista2 = response.getBody();
		
		lista.addAll(lista2);
		
		model.addAttribute("lista", lista);	
			
		return "index";
	}	
	public ResponseEntity<List<Vaga>> method(String link){
		RestTemplate restTemplate  = new RestTemplate();
		
		ResponseEntity<List<Vaga>> response = restTemplate.exchange(
				link, 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Vaga>>() { }
		);
		
		return response;
					
	}
	
	
	
	
}
