package com.resrvahoras.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resrvahoras.springboot.backend.apirest.exceptions.ClienteErrorEmailException;
import com.resrvahoras.springboot.backend.apirest.exceptions.ClienteErrorRutException;
import com.resrvahoras.springboot.backend.apirest.exceptions.ClienteNoExisteException;
import com.resrvahoras.springboot.backend.apirest.models.dao.IClienteDao;
import com.resrvahoras.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		
		// validar que el cliente no exista por su rut
		
		Cliente clienteBuscado = clienteDao.findOneByRut( cliente.getRut() );	
		Cliente clienteBuscadoEmail = clienteDao.findOneByEmail(cliente.getEmail() );
		if( null != clienteBuscado ) {
			//throw new ClienteRegistradoException( "Ya existe un cliente con el rut "+ cliente.getRut() );
			throw new ClienteErrorRutException( "Ya existe un cliente con el rut "+ cliente.getRut() );
		}if (null != clienteBuscadoEmail) {
			throw new ClienteErrorEmailException( "El Email: "  + cliente.getEmail() + " ya está registrado");
		}else {
			return clienteDao.save(cliente);
		}
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		
		Optional<Cliente> clienteAEliminar = clienteDao.findById(id);
		if(clienteAEliminar == null) {
			throw new ClienteNoExisteException("El Cliente con id " + id + " No esta registrado en el sistema");
		}else {
			clienteDao.deleteById(id);
		}
		
	}
}
