package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equiposinstalacion")
public class Equiposinstalacion {
	
	@Id
	private long id_activo;
	@Column(name = "marca")
	private String marca;
	@Column(name = "nro_serial")
	private String nro_serial;
	@Column(name = "color")
	private String color;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "industria")
	private String industria;
	@Column(name = "modelo")
	private String modelo;
	
	public Equiposinstalacion() {
		super();
	}
	public Equiposinstalacion(long id_activo, String marca, String nro_serial, String color, String tipo,
			String industria,String modelo) {
		super();
		this.id_activo = id_activo;
		this.marca = marca;
		this.nro_serial = nro_serial;
		this.color = color;
		this.tipo = tipo;
		this.industria = industria;
		this.modelo = modelo;
	}
	public long getId_activo() {
		return id_activo;
	}
	public void setId_activo(long id_activo) {
		this.id_activo = id_activo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNro_serial() {
		return nro_serial;
	}
	public void setNro_serial(String nro_serial) {
		this.nro_serial = nro_serial;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getIndustria() {
		return industria;
	}
	public void setIndustria(String industria) {
		this.industria = industria;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	

}
