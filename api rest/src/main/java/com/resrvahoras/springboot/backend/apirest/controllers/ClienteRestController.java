package com.resrvahoras.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.resrvahoras.springboot.backend.apirest.exceptions.ClienteErrorEmailException;
import com.resrvahoras.springboot.backend.apirest.exceptions.ClienteErrorRutException;
import com.resrvahoras.springboot.backend.apirest.models.entity.Cliente;
import com.resrvahoras.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente>  create(@RequestBody Cliente cliente) {
		
		try {
			Cliente clienteResponse = clienteService.save(cliente);
			return new ResponseEntity<>( clienteResponse , HttpStatus.OK); // codigo 200
		}catch( ClienteErrorRutException ex ) {
			return new ResponseEntity<>( null , HttpStatus.NOT_ACCEPTABLE); // code 406
		}
		catch( ClienteErrorEmailException ex ) {
			return new ResponseEntity<>( null , HttpStatus.CONFLICT); // code 409
		}
		
	}
}
