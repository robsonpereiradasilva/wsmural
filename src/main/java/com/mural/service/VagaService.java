package com.mural.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mural.model.Vaga;
import com.mural.repository.VagaRepository;

@RestController
public class VagaService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@GetMapping("/vagas")
	List<Vaga> all(){
		return vagaRepository.findAll();
	}
	@PostMapping("/cadastrar")
	public Vaga cadastrarVaga(@Valid @RequestBody Vaga vaga) {
		
		return vagaRepository.save(vaga);
	}	
	
	

}
