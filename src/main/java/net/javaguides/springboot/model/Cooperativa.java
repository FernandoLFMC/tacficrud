package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cooperativa")
public class Cooperativa {
	
	@Id
	private long id_coop;
	@Column (name = "nombre")
	private String nombre;
	@Column(name = "ciudad")
	private String ciudad;
	@Column (name = "direccion")
	private String direccion;
	@Column (name = "telefono")
	private int telefono;
	@Column(name = "nit")
	private int nit;
	@Column(name = "correo")
	private String correo;
	@Column (name = "url")
	private String url;
	
	
	public Cooperativa() {
		super();
	}
	public Cooperativa(long id_coop, String nombre, String ciudad, String direccion, int telefono, int nit,
			String correo, String url) {
		super();
		this.id_coop = id_coop;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nit = nit;
		this.correo = correo;
		this.url = url;
	}
	public long getId_coop() {
		return id_coop;
	}
	public void setId_coop(long id_coop) {
		this.id_coop = id_coop;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
