package net.javaguides.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "activo")
public class Activo implements Serializable{
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "id_activo")
	private long id_activo;
	@Column(name = "id_cuenta")
	private int id_cuenta;
	@Column(name = "id_coop")
	private int id_coop;
	@Column(name = "cod_tipo")
	private int cod_tipo;
	@Column(name = "cod_seccion")
	private String cod_seccion;
	@Column(name = "id_funcionario")
	private String id_funcionario;
	@Column(name = "nombre_tipo")
	private String nombre_tipo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "unidad")
	private String unidad;
	@Column(name = "observacion")
	private String observacion;
	
	@OneToMany(targetEntity = Info_activo.class,
			cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_activo",referencedColumnName = "id_activo")
	private List<Info_activo> info_activo;
	
	@OneToOne(targetEntity = Mobiliarioenseres.class,
			cascade = CascadeType.REMOVE,
			mappedBy = "activo")
	private Mobiliarioenseres Mobiliarioenseres;
	
	@OneToOne(targetEntity = Equiposcomputacion.class,
			cascade = CascadeType.REMOVE,
			mappedBy = "activo")
	private Equiposcomputacion equiposcomputacion;

	
	public Activo() {
		super();
	}

	
	public Activo(long id_activo, int id_cuenta, int id_coop, int cod_tipo, String cod_seccion, String id_funcionario,
			String nombre_tipo, String descripcion, String unidad, String observacion) {
		super();
		this.id_activo = id_activo;
		this.id_cuenta = id_cuenta;
		this.id_coop = id_coop;
		this.cod_tipo = cod_tipo;
		this.cod_seccion = cod_seccion;
		this.id_funcionario = id_funcionario;
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
	
	public int getId_coop() {
		return id_coop;
	}
	public void setId_coop(int id_coop) {
		this.id_coop = id_coop;
	}
	public String getCod_seccion() {
		return cod_seccion;
	}
	public void setCod_seccion(String cod_seccion) {
		this.cod_seccion = cod_seccion;
	}
	public String getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(String id_funcionario) {
		this.id_funcionario = id_funcionario;
	}



	@Override
	public String toString() {
		return "Activo [id_activo=" + id_activo + ", id_cuenta=" + id_cuenta + ", id_coop=" + id_coop + ", cod_tipo="
				+ cod_tipo + ", cod_seccion=" + cod_seccion + ", id_funcionario=" + id_funcionario + ", nombre_tipo="
				+ nombre_tipo + ", descripcion=" + descripcion + ", unidad=" + unidad + ", observacion=" + observacion
				+ "]";
	}



	private static final long serialVersionUID = 1L;

}
