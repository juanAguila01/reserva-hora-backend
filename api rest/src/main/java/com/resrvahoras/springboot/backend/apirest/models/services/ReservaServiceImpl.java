package com.resrvahoras.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resrvahoras.springboot.backend.apirest.exceptions.ReservaErrorCantidadMaximaException;
import com.resrvahoras.springboot.backend.apirest.exceptions.ReservaFechaIncorrectaException;
import com.resrvahoras.springboot.backend.apirest.exceptions.ReservaHoraIncorrectaException;
import com.resrvahoras.springboot.backend.apirest.models.dao.IReservaDao;
import com.resrvahoras.springboot.backend.apirest.models.entity.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	private IReservaDao reservaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Reserva> findByRut(String rut) {
		return reservaDao.findByRut(rut);
		
	}

	@Override
	public List<Reserva> findAll() {
		return (List<Reserva>) reservaDao.findAll();
	}

	@Override
	@Transactional
	public Reserva save(Reserva reserva) {
		int auxiliar = reserva.compareTo(reserva.getFecha());
		if (auxiliar<0){
			throw new ReservaFechaIncorrectaException("fecha mala");
			
		}
		int auxiliar2 = reserva.comparacionHora(reserva.getHora());
		if(auxiliar2<0) {
			throw new ReservaHoraIncorrectaException("hora mala");
		}
		List<Reserva> ReservaHora = reservaDao.findByHora(reserva.getHora());
		if(10 == ReservaHora.size ()) {
			throw new ReservaErrorCantidadMaximaException("No hay mas reservas disponibles en este horario");
		}
		return reservaDao.save(reserva);
	}
	
	
	@Override
	public Reserva saveReserva(Reserva reserva, long id) {
		
		Reserva reservaActual = reservaDao.findById(id);
		
		reservaActual.setEstado(reserva.getEstado());
		return reservaDao.save(reservaActual);
	}
	@Override
	public List<Reserva> findByDireccion(String direccion) {
		return reservaDao.findByDireccion(direccion);
	}

	@Override
	public List<Reserva> findByFecha(String fecha) {
		// TODO Auto-generated method stub
		return reservaDao.findByFecha(fecha);
	}

	@Override
	public List<Reserva> findByEstado(String estado) {
		// TODO Auto-generated method stub
		return reservaDao.findByEstado(estado);
	}

	@Override
	@Transactional(readOnly=true)
	public Reserva findById(Long id) {
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	public List<Reserva> findByHora(String hora) {
		return this.reservaDao.findByHora(hora);
	} 

}
