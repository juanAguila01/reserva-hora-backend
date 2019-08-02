package com.resrvahoras.springboot.backend.apirest.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.resrvahoras.springboot.backend.apirest.exceptions.ReservaErrorCantidadMaximaException;
import com.resrvahoras.springboot.backend.apirest.exceptions.ReservaFechaIncorrectaException;
import com.resrvahoras.springboot.backend.apirest.exceptions.ReservaHoraIncorrectaException;
import com.resrvahoras.springboot.backend.apirest.models.entity.Reserva;
import com.resrvahoras.springboot.backend.apirest.models.services.IReservaService;

@CrossOrigin (origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReservaRestController {

	
	@Autowired
	private IReservaService reservaService;
	
	@GetMapping("/reservas")
	public List<Reserva>listar(){
		return reservaService.findAll();
	}
	
	@GetMapping(path ="/reservas/rut/{rut}" )
	public List<Reserva> showRut (@PathVariable String rut){
		return reservaService.findByRut(rut);
	}
	
	@GetMapping(path ="/reservas/direccion/{direccion}" )
	public List<Reserva> showDireccion (@PathVariable String direccion){
		return reservaService.findByDireccion(direccion);
	}
	
	@GetMapping(path = "/reservas/fecha/{fecha}")
	public List<Reserva> listarFecha(@PathVariable String fecha){		
		return this.reservaService.findByFecha(fecha);
	}
	
	@GetMapping(path = "/reservas/estado/{estado}")
	public List<Reserva> listarEstado(@PathVariable String estado){
		return this.reservaService.findByEstado(estado);
	}
	
	@PostMapping("/reservas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Reserva> create(@RequestBody Reserva reserva){
		try {
			Reserva reservaResponse= reservaService.save(reserva);
			return new ResponseEntity<>(reservaResponse , HttpStatus.OK); // codigo 200
		}catch( ReservaErrorCantidadMaximaException ex ) {
			return new ResponseEntity<>( null , HttpStatus.URI_TOO_LONG); // code 414
		}
		catch( ReservaHoraIncorrectaException ex ) {
			return new ResponseEntity<>( null , HttpStatus.UPGRADE_REQUIRED); // code 426
		}
		catch(ReservaFechaIncorrectaException ex) {
			return new ResponseEntity<>( null , HttpStatus.UNSUPPORTED_MEDIA_TYPE); //code 415
		}
		
		
	}
	@PutMapping("/reservas/{id}")
	public Reserva update(@RequestBody Reserva reserva,@PathVariable Long id) {
		
		
		return reservaService.saveReserva(reserva, id);
	}
	
	@GetMapping("/reservas/hora/{hora}")
	public List<Reserva> listarPorHora(@PathVariable String hora) {
		return this.reservaService.findByHora(hora);
	}
	
}
