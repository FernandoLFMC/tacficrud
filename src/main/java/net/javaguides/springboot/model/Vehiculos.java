package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculos {
	
	@Id
	private long id_activo;
	@Column(name = "ruat")
	private String ruat;
	@Column(name = "nro_placa")
	private String nro_placa;
	@Column(name = "marca")
	private String marca;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "color")
	private String color;
	@Column(name = "modelo")
	private int modelo;
	@Column(name = "nro_chasis")
	private String nro_chasis;
	@Column(name = "nro_motor")
	private String nro_motor;
	@Column(name = "procedencia")
	private String procedencia;
	
	@OneToOne(targetEntity = Activo.class, optional = false)
	@JoinColumn(name = "id_activo", nullable = false)
	private Activo activo;
	
	public Vehiculos() {
		super();
	}
	public Vehiculos(long id_activo, String ruat, String nro_placa, String marca, String tipo, String color, int modelo,
			String nro_chasis, String nro_motor, String procedencia) {
		super();
		this.id_activo = id_activo;
		this.ruat = ruat;
		this.nro_placa = nro_placa;
		this.marca = marca;
		this.tipo = tipo;
		this.color = color;
		this.modelo = modelo;
		this.nro_chasis = nro_chasis;
		this.nro_motor = nro_motor;
		this.procedencia = procedencia;
	}
	public long getId_activo() {
		return id_activo;
	}
	public void setId_activo(long id_activo) {
		this.id_activo = id_activo;
	}
	public String getRuat() {
		return ruat;
	}
	public void setRuat(String ruat) {
		this.ruat = ruat;
	}
	public String getNro_placa() {
		return nro_placa;
	}
	public void setNro_placa(String nro_placa) {
		this.nro_placa = nro_placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	public String getNro_chasis() {
		return nro_chasis;
	}
	public void setNro_chasis(String nro_chasis) {
		this.nro_chasis = nro_chasis;
	}
	public String getNro_motor() {
		return nro_motor;
	}
	public void setNro_motor(String nro_motor) {
		this.nro_motor = nro_motor;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	

}
