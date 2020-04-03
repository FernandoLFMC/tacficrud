package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {
	
	@Id
	private int id_cuenta;
	@Column(name = "descripcion_cuenta")
	private String descripcion_cuenta;
	
	
	public Cuenta() {
		super();
	}
	public Cuenta(int id_cuenta, String descripcion_cuenta) {
		super();
		this.id_cuenta = id_cuenta;
		this.descripcion_cuenta = descripcion_cuenta;
	}
	public int getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public String getDescripcion_cuenta() {
		return descripcion_cuenta;
	}
	public void setDescripcion_cuenta(String descripcion_cuenta) {
		this.descripcion_cuenta = descripcion_cuenta;
	}
	

}
