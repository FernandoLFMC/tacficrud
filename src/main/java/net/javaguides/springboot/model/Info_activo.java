package net.javaguides.springboot.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "info_activo")
public class Info_activo implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "id_info")
	private long id_info;
	@Column(name = "id_activo")
	private int id_activo;
	@Column(name = "funcionario_anterior")
	private String funcionario_anterior;
	@Column(name = "seccion_anterior")
	private String seccion_anterior;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_movimiento")
	private Calendar fecha_movimiento;
	
	@Column(name = "motivo")
	private String motivo;
	@Column(name = "funcionario_actual")
	private String funcionario_actual;
	@Column(name = "seccion_actual")
	private String seccion_actual;
	
	public Info_activo() {
		super();
	}
	public Info_activo(int id_activo,String funcionario_anterior, String seccion_anterior,Calendar fecha_movimineto, String motivo,String funcionario_actual, String seccion_actual) {
		super();
		this.id_activo = id_activo;
		this.funcionario_anterior = funcionario_anterior;
		this.seccion_anterior = seccion_anterior;
		this.fecha_movimiento = fecha_movimineto;
		this.motivo = motivo;
		this.funcionario_actual = funcionario_actual;
		this.seccion_actual = seccion_actual;
	}
	public long getId_info() {
		return id_info;
	}
	public void setId_info(long id_info) {
		this.id_info = id_info;
	}
	public int getId_activo() {
		return id_activo;
	}
	public void setId_activo(int id_activo) {
		this.id_activo = id_activo;
	}

	public String getFuncionario_anterior() {
		return funcionario_anterior;
	}
	public void setFuncionario_anterior(String funcionario_anterior) {
		this.funcionario_anterior = funcionario_anterior;
	}
	public String getSeccion_anterior() {
		return seccion_anterior;
	}
	public void setSeccion_anterior(String seccion_anterior) {
		this.seccion_anterior = seccion_anterior;
	}
	public Calendar getFecha_movimiento() {
		return fecha_movimiento;
	}
	public void setFecha_movimiento(Calendar fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}

	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public String getFuncionario_actual() {
		return funcionario_actual;
	}
	public void setFuncionario_actual(String funcionario_actual) {
		this.funcionario_actual = funcionario_actual;
	}
	public String getSeccion_actual() {
		return seccion_actual;
	}
	public void setSeccion_actual(String seccion_actual) {
		this.seccion_actual = seccion_actual;
	}
	@Override
	public String toString() {
		return "Info_activo [id_info=" + id_info + ", id_activo=" + id_activo + ", funcionario_anterior="
				+ funcionario_anterior + ", seccion_anterior=" + seccion_anterior + ", fecha_movimiento="
				+ fecha_movimiento + ", motivo=" + motivo + "]";
	}









	private static final long serialVersionUID = 1L;

}
