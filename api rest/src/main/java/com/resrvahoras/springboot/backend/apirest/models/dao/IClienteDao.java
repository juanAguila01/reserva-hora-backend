package com.resrvahoras.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.resrvahoras.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	
	// select * from cliente where rut = rut
	Cliente findOneByRut( String rut );
	
	Cliente findOneByEmail( String email );
	
	Cliente findOneById( long id );
	
	

}
