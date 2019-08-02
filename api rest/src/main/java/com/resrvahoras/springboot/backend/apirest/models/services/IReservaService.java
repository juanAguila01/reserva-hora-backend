package com.resrvahoras.springboot.backend.apirest.models.services;

import java.util.List;

import com.resrvahoras.springboot.backend.apirest.models.entity.Reserva;

public interface IReservaService {
	
	public List<Reserva> findByRut(String rut);

	public List<Reserva> findAll(); 

	public Reserva save(Reserva reserva);
	public Reserva saveReserva(Reserva reserva, long id);

	public List<Reserva> findByDireccion(String direccion);

	public List<Reserva> findByFecha(String fecha);
	
	public List<Reserva> findByHora(String hora);

	public List<Reserva> findByEstado(String estado);
	
	public Reserva findById(Long id);

}