package com.resrvahoras.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.resrvahoras.springboot.backend.apirest.models.entity.Reserva;

public interface IReservaDao extends CrudRepository<Reserva, Long> {
	
	public List<Reserva> findByRut(String rut);
	
	public List<Reserva> findByDireccion(String direccion);
	
	public List<Reserva> findByFecha(String fecha);
	
	public List<Reserva> findByEstado(String estado);
	
	public Reserva findOneByFecha(String fecha);
	
	public List<Reserva> findByHora(String hora);
	
	public Reserva findById(long id);
	
	

}
