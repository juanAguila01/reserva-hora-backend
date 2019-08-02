package com.resrvahoras.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_recepcionista")
	private Recepcionista recepcionista;

	@Column
	private String fecha;
	@Column
	private String hora;
	@Column
	private String estado;
	@Column
	private String nombre;
	@Column
	private String rut;
	@Column
	private String telefono;
	@Column
	private String direccion;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Recepcionista getRecepcionista() {
		return recepcionista;
	}

	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int compareTo(String fecha) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Chile"));
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		year *=1000;
		month *=100;
		
		int anio = Integer.parseInt(fecha.substring(0,4));
		int mes = Integer.parseInt(fecha.substring(5, 7));
		int dia = Integer.parseInt(fecha.substring(8)) ;
		
		anio *=1000;
		mes *=100;
		
		if(mes<10) {
			anio *=10;
		}
		if(dia<10) {
			mes *=10;
		}
		if(month<10) {
			year *=10;
		}
		if(day<10) {
			month *=10;
		}
		int actual =anio+mes+dia;
		int reserva = year+month+day;
		return actual-reserva;
		}
	
	
	public int comparacionHora(String hora) {
			LocalTime tiempoActual = LocalTime.now();
			int horaActual = tiempoActual.getHour();
			int minutosActuales = tiempoActual.getMinute();
			
			int horaReserva = Integer.parseInt(hora.substring(0, 2));
			int minutosReserva = Integer.parseInt(hora.substring(3));
			
			horaActual *=100;
			horaReserva *=100;
			
			if(minutosActuales<10) {
				horaActual *=10;
			}
			if(minutosReserva<10) {
				horaReserva *=10;
			}
			
			int tiempoReserva = horaReserva+minutosReserva;
			int actual = horaActual+minutosActuales;

			
			return tiempoReserva-actual;
		}
}
