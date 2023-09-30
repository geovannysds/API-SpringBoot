package com.geovanny.crm.pessoaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.geovanny.crm.model.Endereco;
import com.geovanny.crm.pessoaapi.repository.EnderecoRepository;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List<Endereco> listar(){
		return enderecoRepository.findAll();
	}
	
	  @PostMapping
	    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco) {
	        
	        Endereco enderecoCriado = enderecoRepository.save(endereco);

	        
	        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoCriado);
	    }
}