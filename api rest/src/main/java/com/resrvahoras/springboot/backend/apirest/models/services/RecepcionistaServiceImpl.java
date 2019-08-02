package com.resrvahoras.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resrvahoras.springboot.backend.apirest.exceptions.RecepcionistaDireccionException;
import com.resrvahoras.springboot.backend.apirest.exceptions.RecepcionistaNoExisteException;
import com.resrvahoras.springboot.backend.apirest.exceptions.RecepcionistaNombreException;
import com.resrvahoras.springboot.backend.apirest.models.dao.IRecepcionistaDao;

import com.resrvahoras.springboot.backend.apirest.models.entity.Recepcionista;

@Service
public class RecepcionistaServiceImpl implements IRecepcionistaService{

	@Autowired
	private IRecepcionistaDao recepcionistaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Recepcionista> findAll() {
		return (List<Recepcionista>) recepcionistaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Recepcionista findById(Long id) {
		return recepcionistaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Recepcionista save(Recepcionista recepcionista) {
		
		Recepcionista recepcionistaBuscado = recepcionistaDao.findByNombre(recepcionista.getNombre());
		Recepcionista recepDireccion = recepcionistaDao.findByDireccion(recepcionista.getDireccion());
		
		
		if(recepcionistaBuscado != null) {
			throw new RecepcionistaNombreException(" Ya hay un recepcionista que esta asignado bajo el nombre de: " + recepcionista.getNombre());
		}else if(recepDireccion != null) {
			throw new RecepcionistaDireccionException(" Direccion ya esta en uso ");
		}else {
			return recepcionistaDao.save(recepcionista);
		}
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		
		Optional<Recepcionista> resepAEliminar = recepcionistaDao.findById(id);
		
		if(resepAEliminar == null) {
			throw new RecepcionistaNoExisteException("El recepcionista que se intenta eliminar no existe.");
		}else {
			recepcionistaDao.deleteById(id);
		}
		
	}

	@Override
	public Recepcionista saveRecepcionista(Recepcionista recepcionista, long id) {
		Recepcionista recepActual = recepcionistaDao.findById(id);
		
		recepActual.setContraseña(recepcionista.getContrasena());
		recepActual.setDireccion(recepcionista.getDireccion());
		recepActual.setHoraApertura(recepcionista.getHoraApertura());
		recepActual.setHoraCierre(recepcionista.getHoraCierre());
		recepActual.setNombre(recepcionista.getNombre());
		
		return recepcionistaDao.save(recepActual);
	}

	@Override
	public Recepcionista findByDireccion(String direccion) {
		return this.recepcionistaDao.findByDireccion(direccion);
	}
}
