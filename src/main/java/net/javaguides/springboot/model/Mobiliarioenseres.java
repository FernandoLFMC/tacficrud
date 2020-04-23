package net.javaguides.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Mobiliarioenseres implements Serializable{
	


	@Id
	private long id_activo;
	@Column(name = "material")
	private String material;
	@Column(name = "color")
	private String color;
	
	@OneToOne(targetEntity = Activo.class, optional = false)
	@JoinColumn(name = "id_activo", nullable = false)
	private Activo activo;


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
	
	

	@Override
	public String toString() {
		return "Mobiliarioenseres [id_activo=" + id_activo + ", material=" + material + ", color=" + color + "]";
	}
	
	private static final long serialVersionUID = 1L;

}
