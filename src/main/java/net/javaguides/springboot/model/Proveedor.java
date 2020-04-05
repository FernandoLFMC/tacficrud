package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	private long nit;
	@Column(name = "nombre_tienda")
	private String nombre_tienda;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private int telefono;
	
	public Proveedor() {
		super();
	}
	public Proveedor(long nit, String nombre_tienda, String direccion, int telefono) {
		super();
		this.nit = nit;
		this.nombre_tienda = nombre_tienda;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public long getNit() {
		return nit;
	}
	public void setNit(long nit) {
		this.nit = nit;
	}
	public String getNombre_tienda() {
		return nombre_tienda;
	}
	public void setNombre_tienda(String nombre_tienda) {
		this.nombre_tienda = nombre_tienda;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	

}
