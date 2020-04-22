package net.javaguides.springboot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name = "fecha_movimiento")
	private Date fecha_movimiento;
	@Column(name = "estado_op_nop")
	private String estado_op_nop;
	@Column(name = "motivo")
	private String motivo;
	
	public Info_activo() {
		super();
	}
	public Info_activo(int id_activo,String funcionario_anterior, String seccion_anterior,Date fecha_movimineto,
			String estado_op_nop, String motivo) {
		super();
		this.id_activo = id_activo;
		this.funcionario_anterior = funcionario_anterior;
		this.seccion_anterior = seccion_anterior;
		this.fecha_movimiento = fecha_movimineto;
		this.estado_op_nop = estado_op_nop;
		this.motivo = motivo;
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
	public Date getFecha_movimiento() {
		return fecha_movimiento;
	}
	public void setFecha_movimiento(Date fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}
	public String getEstado_op_nop() {
		return estado_op_nop;
	}
	public void setEstado_op_nop(String estado_op_nop) {
		this.estado_op_nop = estado_op_nop;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	

	@Override
	public String toString() {
		return "Info_activo [id_info=" + id_info + ", id_activo=" + id_activo + ", funcionario_anterior="
				+ funcionario_anterior + ", seccion_anterior=" + seccion_anterior + ", fecha_movimiento="
				+ fecha_movimiento + ", estado_op_nop=" + estado_op_nop + ", motivo=" + motivo + "]";
	}









	private static final long serialVersionUID = 1L;

}
