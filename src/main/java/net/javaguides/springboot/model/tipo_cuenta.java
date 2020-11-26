package net.javaguides.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_cuenta")
public class tipo_cuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "id_num")
	private long id_num;
	@Column(name = "id_cuenta")
	private int id_cuenta;
	@Column(name = "num")
	private int num;
	@Column(name = "nombre")
	private String nombre;
	
	
	
	public tipo_cuenta() {
		super();
	}
	public tipo_cuenta(long id_num, int id_cuenta, int num, String nombre) {
		super();
		this.id_num = id_num;
		this.id_cuenta = id_cuenta;
		this.num = num;
		this.nombre = nombre;
	}
	public long getId_num() {
		return id_num;
	}
	public void setId_num(long id_num) {
		this.id_num = id_num;
	}
	public int getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
