package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "id_funcionario")
	private String id_funcionario;
	@Column(name = "login")
	private String login;
	@Column(name = "pwd")
	private String pwd;
	@Column(name = "estado_ac_inac")
	private int estado_ac_inac;
	
	
	public Usuario() {
		super();
	}
	public Usuario(String id_funcionario, String login, String pwd, int estado_ac_inac) {
		super();
		this.id_funcionario = id_funcionario;
		this.login = login;
		this.pwd = pwd;
		this.estado_ac_inac = estado_ac_inac;
	}
	public String getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(String id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getEstado_ac_inac() {
		return estado_ac_inac;
	}
	public void setEstado_ac_inac(int estado_ac_inac) {
		this.estado_ac_inac = estado_ac_inac;
	}
	
	

}
