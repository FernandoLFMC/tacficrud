package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activo")
public class Activo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "id_activo")
	private long id_activo;
	@Column(name = "id_cuenta")
	private int id_cuenta;
	@Column(name = "cod_tipo")
	private int cod_tipo;
	@Column(name = "nombre_tipo")
	private String nombre_tipo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "unidad")
	private String unidad;
	@Column(name = "observacion")
	private String observacion;
	
	public Activo() {
		super();
	}
	public Activo(long id_activo, int id_cuenta, int cod_tipo, String nombre_tipo, String descripcion, String unidad,
			String observacion) {
		super();
		this.id_activo = id_activo;
		this.id_cuenta = id_cuenta;
		this.cod_tipo = cod_tipo;
		this.nombre_tipo = nombre_tipo;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.observacion = observacion;
	}
	public long getId_activo() {
		return id_activo;
	}
	public void setId_activo(long id_activo) {
		this.id_activo = id_activo;
	}
	public int getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public int getCod_tipo() {
		return cod_tipo;
	}
	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
	}
	public String getNombre_tipo() {
		return nombre_tipo;
	}
	public void setNombre_tipo(String nombre_tipo) {
		this.nombre_tipo = nombre_tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	

}
