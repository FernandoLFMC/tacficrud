package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adquisicion")
public class Adquisicion {
	
	@Id
	@Column(name = "id_adquisicion")
	private String id_adquisicion;
	@Column(name = "porcentaje")
	private float porcentaje;
	@Column(name = "nombre_tipo_adq")
	private String nombre_tipo_adq;
	
	public Adquisicion() {
		super();
	}
	public Adquisicion(String id_adquisicion, float porcentaje, String nombre_tipo_adq) {
		super();
		this.id_adquisicion = id_adquisicion;
		this.porcentaje = porcentaje;
		this.nombre_tipo_adq = nombre_tipo_adq;
	}
	public String getId_adquisicion() {
		return id_adquisicion;
	}
	public void setId_adquisicion(String id_adquisicion) {
		this.id_adquisicion = id_adquisicion;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public String getNombre_tipo_adq() {
		return nombre_tipo_adq;
	}
	public void setNombre_tipo_adq(String nombre_tipo_adq) {
		this.nombre_tipo_adq = nombre_tipo_adq;
	}
	

}
