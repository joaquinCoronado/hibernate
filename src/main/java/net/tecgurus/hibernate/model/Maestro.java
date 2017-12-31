package net.tecgurus.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maestro")
public class Maestro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaestro;
	
	private String nombre;
	
	
	//Constructores.
	
	public Maestro() {
		
	}
	
	public Maestro(int idMaestro, String nombre) {
		this.idMaestro = idMaestro;
		this.nombre = nombre;
	}
	
	
	//Metodos set y get
	public int getIdMaestro() {
		return idMaestro;
	}
	public void setIdMaestro(int idMaestro) {
		this.idMaestro = idMaestro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Maestro [idMaestro=" + idMaestro + ", nombre=" + nombre + "]";
	}

	
}
