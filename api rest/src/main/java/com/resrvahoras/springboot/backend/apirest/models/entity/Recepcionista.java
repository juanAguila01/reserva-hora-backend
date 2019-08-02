package com.resrvahoras.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recepcionistas")
public class Recepcionista implements Serializable {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nombre;
	@Column
	private String direccion;
	@Column(name = "hora_apertura")
	private String horaApertura;
	@Column(name = "hora_cierre")
	private String horaCierre;
	@Column
	private String contrasena;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_admin")
	private Admin admin;
	
	@OneToMany(mappedBy ="recepcionista", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Reserva> reserva = new ArrayList<>();


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContraseña(String contrasena) {
		this.contrasena = contrasena;
	}

	
	private static final long serialVersionUID = 2L;
}
