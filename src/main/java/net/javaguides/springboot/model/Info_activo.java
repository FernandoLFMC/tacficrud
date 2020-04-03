package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_activo")
public class Info_activo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_info;
	@Column(name = "id_activo")
	private int id_activo;
	@Column(name = "id_coop")
	private int id_coop;
	@Column(name = "cod_seccion")
	private String cod_seccion;
	@Column(name = "id_funcionario")
	private String id_funcionario;
	@Column(name = "estado_op_nop")
	private String estado_op_nop;
	@Column(name = "motivo")
	private String motivo;
	
	public Info_activo() {
		super();
	}
	public Info_activo(long id_info, int id_activo, int id_coop, String cod_seccion, String id_funcionario,
			String estado_op_nop, String motivo) {
		super();
		this.id_info = id_info;
		this.id_activo = id_activo;
		this.id_coop = id_coop;
		this.cod_seccion = cod_seccion;
		this.id_funcionario = id_funcionario;
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
	

}
