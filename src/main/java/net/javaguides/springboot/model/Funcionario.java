package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	
	@Id
	@Column (name = "id_funcionario")
	private String id_funcionario;
	@Column(name = "cod_seccion")
	private String cod_seccion;
	@Column(name = "id_coop")
	private int id_coop;
	@Column(name = "id_profesion")
	private int id_profesion;
	@Column(name = "ci")
	private String ci;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "ap_paterno")
	private String ap_paterno;
	@Column(name = "ap_materno")
	private String ap_materno;
	@Column(name = "cargo")
	private String cargo;
	@Column(name = "estado")
	private String estado;
	
	
	public Funcionario() {
		super();
	}
	public Funcionario(String id_funcionario, String cod_seccion, int id_coop, int id_profesion, String ci,
			String nombre, String ap_paterno, String ap_materno, String cargo, String estado) {
		super();
		this.id_funcionario = id_funcionario;
		this.cod_seccion = cod_seccion;
		this.id_coop = id_coop;
		this.id_profesion = id_profesion;
		this.ci = ci;
		this.nombre = nombre;
		this.ap_paterno = ap_paterno;
		this.ap_materno = ap_materno;
		this.cargo = cargo;
		this.estado = estado;
	}
	public String getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(String id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public String getCod_seccion() {
		return cod_seccion;
	}
	public void setCod_seccion(String cod_seccion) {
		this.cod_seccion = cod_seccion;
	}
	public int getId_coop() {
		return id_coop;
	}
	public void setId_coop(int id_coop) {
		this.id_coop = id_coop;
	}
	public int getId_profesion() {
		return id_profesion;
	}
	public void setId_profesion(int id_profesion) {
		this.id_profesion = id_profesion;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp_paterno() {
		return ap_paterno;
	}
	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}
	public String getAp_materno() {
		return ap_materno;
	}
	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
