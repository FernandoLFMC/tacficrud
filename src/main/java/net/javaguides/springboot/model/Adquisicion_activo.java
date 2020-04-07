package net.javaguides.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "adquisicion_activo")
public class Adquisicion_activo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "id_adq_ac")
	private long id_adq_ac;
	@Column(name = "id_activo")
	private int id_activo;
	@Column(name = "id_adquisicion")
	private String id_adquisicion;
	@Column(name = "nit")
	private int nit;
	@Column(name = "fecha_adquisicion")
	private Date fecha_adquisicion;
	@Column(name = "comprobante_contable")
	private int comprobante_contable;
	@Column(name = "costo_adquisicion")
	private float costo_adquisicion;
	
	
	public Adquisicion_activo() {
		super();
	}
	public Adquisicion_activo(long id_adq_ac, int id_activo, String id_adquisicion, int nit, Date fecha_adquisicion,
			int comprobante_contable, float costo_adquisicion) {
		super();
		this.id_adq_ac = id_adq_ac;
		this.id_activo = id_activo;
		this.id_adquisicion = id_adquisicion;
		this.nit = nit;
		this.fecha_adquisicion = fecha_adquisicion;
		this.comprobante_contable = comprobante_contable;
		this.costo_adquisicion = costo_adquisicion;
	}
	public long getId_adq_ac() {
		return id_adq_ac;
	}
	public void setId_adq_ac(long id_adq_ac) {
		this.id_adq_ac = id_adq_ac;
	}
	public int getId_activo() {
		return id_activo;
	}
	public void setId_activo(int id_activo) {
		this.id_activo = id_activo;
	}
	public String getId_adquisicion() {
		return id_adquisicion;
	}
	public void setId_adquisicion(String id_adquisicion) {
		this.id_adquisicion = id_adquisicion;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public Date getFecha_adquisicion() {
		return fecha_adquisicion;
	}
	public void setFecha_adquisicion(Date fecha_adquisicion) {
		this.fecha_adquisicion = fecha_adquisicion;
	}
	public int getComprobante_contable() {
		return comprobante_contable;
	}
	public void setComprobante_contable(int comprobante_contable) {
		this.comprobante_contable = comprobante_contable;
	}
	public float getCosto_adquisicion() {
		return costo_adquisicion;
	}
	public void setCosto_adquisicion(float costo_adquisicion) {
		this.costo_adquisicion = costo_adquisicion;
	}
	

}
