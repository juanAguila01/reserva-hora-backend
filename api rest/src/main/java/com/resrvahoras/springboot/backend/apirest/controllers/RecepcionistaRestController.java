  package com.resrvahoras.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.resrvahoras.springboot.backend.apirest.exceptions.RecepcionistaDireccionException;
import com.resrvahoras.springboot.backend.apirest.exceptions.RecepcionistaNombreException;
import com.resrvahoras.springboot.backend.apirest.models.entity.Recepcionista;
import com.resrvahoras.springboot.backend.apirest.models.services.IRecepcionistaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RecepcionistaRestController {

	@Autowired
	private IRecepcionistaService recepcionistaService;
	
	@GetMapping("/recepcionistas")
	public List<Recepcionista> index(){
		return recepcionistaService.findAll();
	}
	
	@GetMapping("/recepcionistas/{id}")
	public Recepcionista show(@PathVariable Long id) {
		return recepcionistaService.findById(id);
	}
	
	@PostMapping("/recepcionistas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Recepcionista> create(@RequestBody Recepcionista recepcionista) {
		
		try {
			Recepcionista recepcionistaResponse = recepcionistaService.save(recepcionista);
			return new ResponseEntity<>( recepcionistaResponse , HttpStatus.OK);
		}catch (RecepcionistaNombreException ex) {
			return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);//400
		}catch (RecepcionistaDireccionException ex) {
			return new ResponseEntity<>(null , HttpStatus.FORBIDDEN);//403
		}
	}
	
	
	@PutMapping("/recepcionistas/{id}")
	public Recepcionista update(@RequestBody Recepcionista recepcionista, @PathVariable Long id) {
		
		
		return recepcionistaService.saveRecepcionista(recepcionista, id);
	}
	
	@DeleteMapping("/recepcionistas/{id}")
	public void delete(@PathVariable Long id) {
		recepcionistaService.delete(id);
	}
}
