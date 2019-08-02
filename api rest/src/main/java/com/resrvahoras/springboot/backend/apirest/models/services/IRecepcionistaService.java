package com.resrvahoras.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.resrvahoras.springboot.backend.apirest.models.entity.Recepcionista;

@Service
public interface IRecepcionistaService {
	
	public List<Recepcionista> findAll();
	
	public Recepcionista findById(Long id);
	
	public Recepcionista save(Recepcionista recepcionista);
	
	public void delete(Long id);
	
	public Recepcionista saveRecepcionista(Recepcionista recepcionista, long id);
	
	public Recepcionista findByDireccion(String direccion);
}
