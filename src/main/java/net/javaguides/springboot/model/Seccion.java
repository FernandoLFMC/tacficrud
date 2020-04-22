package net.javaguides.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seccion")
public class Seccion implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cod_seccion")
	private String cod_seccion;
	@Column(name = "nombre_seccion")
	private String nombre_seccion;
	
	
	public Seccion() {
		super();
	}
	public Seccion(String cod_seccion, String nombre_seccion) {
		super();
		this.cod_seccion = cod_seccion;
		this.nombre_seccion = nombre_seccion;
	}
	public String getCod_seccion() {
		return cod_seccion;
	}
	public void setCod_seccion(String cod_seccion) {
		this.cod_seccion = cod_seccion;
	}
	public String getNombre_seccion() {
		return nombre_seccion;
	}
	public void setNombre_seccion(String nombre_seccion) {
		this.nombre_seccion = nombre_seccion;
	}
	
	
	
}
