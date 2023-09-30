package com.geovanny.crm.pessoaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.geovanny.crm.model.Pessoa;
import com.geovanny.crm.pessoaapi.repository.PessoaRepository;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository PessoaRepository;
	
	@GetMapping
	public List<Pessoa> mostrar(){
		return PessoaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
	    
	    Pessoa pessoaCriada = PessoaRepository.save(pessoa);

	   
	    return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCriada);
	}
}