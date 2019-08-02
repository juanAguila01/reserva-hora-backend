package com.resrvahoras.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.resrvahoras.springboot.backend.apirest.models.entity.Recepcionista;

public interface IRecepcionistaDao extends CrudRepository<Recepcionista, Long>{
	
	Recepcionista findByNombre( String nombre );
	
	Recepcionista findById(long id);
	
	Recepcionista findByDireccion(String direccion);
	
	

	
}
