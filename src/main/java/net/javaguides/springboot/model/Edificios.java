package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edificios")
public class Edificios {
	
	@Id
	private long id_activo;
	@Column(name = "cod_catastro")
	private String cod_catastro;
	@Column(name = "superficie")
	private float superficie;
	@Column(name = "matricula_ddrr")
	private String matricula_ddrr;
	@Column(name = "propietario")
	private String propietario;
	@Column(name = "departamento")
	private String departamento;
	@Column(name = "ciudad")
	private String ciudad;
	@Column(name = "direccion")
	private String direccion;
	
	public Edificios() {
		super();
	}
	public Edificios(long id_activo, String cod_catastro, float superficie, String matricula_ddrr, String propietario,
			String departamento, String ciudad, String direccion) {
		super();
		this.id_activo = id_activo;
		this.cod_catastro = cod_catastro;
		this.superficie = superficie;
		this.matricula_ddrr = matricula_ddrr;
		this.propietario = propietario;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}
	public long getId_activo() {
		return id_activo;
	}
	public void setId_activo(long id_activo) {
		this.id_activo = id_activo;
	}
	public String getCod_catastro() {
		return cod_catastro;
	}
	public void setCod_catastro(String cod_catastro) {
		this.cod_catastro = cod_catastro;
	}
	public float getSuperficie() {
		return superficie;
	}
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	public String getMatricula_ddrr() {
		return matricula_ddrr;
	}
	public void setMatricula_ddrr(String matricula_ddrr) {
		this.matricula_ddrr = matricula_ddrr;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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
	
	
	

}
