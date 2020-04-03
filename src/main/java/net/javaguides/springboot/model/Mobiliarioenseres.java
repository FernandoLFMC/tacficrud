package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Mobiliarioenseres {
	
	@Id
	private long id_activo;
	@Column(name = "material")
	private String material;
	@Column(name = "color")
	private String color;
	
	public Mobiliarioenseres() {
		super();
	}
	public Mobiliarioenseres(long id_activo, String material, String color) {
		super();
		this.id_activo = id_activo;
		this.material = material;
		this.color = color;
	}
	public long getId_activo() {
		return id_activo;
	}
	public void setId_activo(long id_activo) {
		this.id_activo = id_activo;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

}
