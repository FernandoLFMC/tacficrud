package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "depreciacion")
public class Depreciacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_depre;
	@Column(name = "id_activo")
	private int id_activo;
	@Column(name = "valor_contabilizado_afecha")
	private float valor_contabilizado_afecha;
	@Column(name = "porcentaje_depreciacion")
	private float porcentaje_depreciacion;
	@Column(name = "depreciacion_mensual")
	private float depreciacion_mensual;
	@Column(name = "total_mes_transcurrido")
	private int total_mes_transcurridos;
	@Column(name = "depreciacion_acumulada_afecha")
	private float depreciacion_acumulada_afecha;
	@Column(name = "total_depreciacion_afecha")
	private float total_depreciacion_afecha;
	@Column(name = "valor_neto_afecha")
	private float valor_neto_afecha;
	
	
	public Depreciacion() {
		super();
	}
	public Depreciacion(long id_depre, int id_activo, float valor_contabilizado_afecha, float porcentaje_depreciacion,
			float depreciacion_mensual, int total_mes_transcurridos, float depreciacion_acumulada_afecha,
			float total_depreciacion_afecha, float valor_neto_afecha) {
		super();
		this.id_depre = id_depre;
		this.id_activo = id_activo;
		this.valor_contabilizado_afecha = valor_contabilizado_afecha;
		this.porcentaje_depreciacion = porcentaje_depreciacion;
		this.depreciacion_mensual = depreciacion_mensual;
		this.total_mes_transcurridos = total_mes_transcurridos;
		this.depreciacion_acumulada_afecha = depreciacion_acumulada_afecha;
		this.total_depreciacion_afecha = total_depreciacion_afecha;
		this.valor_neto_afecha = valor_neto_afecha;
	}
	public long getId_depre() {
		return id_depre;
	}
	public void setId_depre(long id_depre) {
		this.id_depre = id_depre;
	}
	public int getId_activo() {
		return id_activo;
	}
	public void setId_activo(int id_activo) {
		this.id_activo = id_activo;
	}
	public float getValor_contabilizado_afecha() {
		return valor_contabilizado_afecha;
	}
	public void setValor_contabilizado_afecha(float valor_contabilizado_afecha) {
		this.valor_contabilizado_afecha = valor_contabilizado_afecha;
	}
	public float getPorcentaje_depreciacion() {
		return porcentaje_depreciacion;
	}
	public void setPorcentaje_depreciacion(float porcentaje_depreciacion) {
		this.porcentaje_depreciacion = porcentaje_depreciacion;
	}
	public float getDepreciacion_mensual() {
		return depreciacion_mensual;
	}
	public void setDepreciacion_mensual(float depreciacion_mensual) {
		this.depreciacion_mensual = depreciacion_mensual;
	}
	public int getTotal_mes_transcurridos() {
		return total_mes_transcurridos;
	}
	public void setTotal_mes_transcurridos(int total_mes_transcurridos) {
		this.total_mes_transcurridos = total_mes_transcurridos;
	}
	public float getDepreciacion_acumulada_afecha() {
		return depreciacion_acumulada_afecha;
	}
	public void setDepreciacion_acumulada_afecha(float depreciacion_acumulada_afecha) {
		this.depreciacion_acumulada_afecha = depreciacion_acumulada_afecha;
	}
	public float getTotal_depreciacion_afecha() {
		return total_depreciacion_afecha;
	}
	public void setTotal_depreciacion_afecha(float total_depreciacion_afecha) {
		this.total_depreciacion_afecha = total_depreciacion_afecha;
	}
	public float getValor_neto_afecha() {
		return valor_neto_afecha;
	}
	public void setValor_neto_afecha(float valor_neto_afecha) {
		this.valor_neto_afecha = valor_neto_afecha;
	}
	

}
