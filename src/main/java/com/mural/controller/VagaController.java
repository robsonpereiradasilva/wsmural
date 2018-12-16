package com.mural.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
	
	
	@GetMapping("/")
	public String vagas (Model model) {
		ResponseEntity <List<Vaga>> response;
		response = this.method("https://wsemp02.herokuapp.com");
		System.out.println(response);
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
