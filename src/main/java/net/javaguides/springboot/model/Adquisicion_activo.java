package net.javaguides.springboot.model;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "adquisicion_activo")
public class Adquisicion_activo {
	
	@Id
	private long id_activo;
	@Column(name = "id_adquisicion")
	private String id_adquisicion;
	@Column(name = "nit")
	private int nit;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_adquisicion")
	private Calendar fecha_adquisicion;
	
	
	@Column(name = "comprobante_contable")
	private int comprobante_contable;
	@Column(name = "nro_factura")
	private int nro_factura;
	@Column(name = "costo_adquisicion")
	private float costo_adquisicion;
	
	@OneToOne(targetEntity = Activo.class)
	@JoinColumn(name = "id_activo")
	private Activo activo;
	
	public Adquisicion_activo() {
		super();
	}
	public Adquisicion_activo(long id_activo, String id_adquisicion, int nit, Calendar fecha_adquisicion,
			int comprobante_contable, int nro_factura, float costo_adquisicion) {
		super();
		this.id_activo = id_activo;
		this.id_adquisicion = id_adquisicion;
		this.nit = nit;
		this.fecha_adquisicion = fecha_adquisicion;
		this.comprobante_contable = comprobante_contable;
		this.nro_factura = nro_factura;
		this.costo_adquisicion = costo_adquisicion;
	}
	public long getId_activo() {
		return id_activo;
	}
	public void setId_activo(long id_activo) {
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
	public Calendar getFecha_adquisicion() {
		return fecha_adquisicion;
	}
	public void setFecha_adquisicion(Calendar fecha_adquisicion) {
		this.fecha_adquisicion = fecha_adquisicion;
	}
	public int getComprobante_contable() {
		return comprobante_contable;
	}
	public void setComprobante_contable(int comprobante_contable) {
		this.comprobante_contable = comprobante_contable;
	}
	
	
	public int getNro_factura() {
		return nro_factura;
	}
	public void setNro_factura(int nro_factura) {
		this.nro_factura = nro_factura;
	}
	public float getCosto_adquisicion() {
		return costo_adquisicion;
	}
	public void setCosto_adquisicion(float costo_adquisicion) {
		this.costo_adquisicion = costo_adquisicion;
	}
	

}
