package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesion")
public class Profesion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "id_profesion")
	private long id_profesion;
	@Column(name = "nomb_profesion")
	private String nomb_profesion;
	
	public Profesion() {
		super ();
	}
	
	public Profesion(long id_profesion, String nomb_profesion) {
		super ();
		this.id_profesion = id_profesion;
		this.nomb_profesion = nomb_profesion;
	}
	public long getId_profesion() {
		return id_profesion;
	}
	public void setId_profesion(long id_profesion) {
		this.id_profesion = id_profesion;
	}
	public String getNomb_profesion() {
		return nomb_profesion;
	}
	public void setNomb_profesion (String nomb_profesion) {
		this.nomb_profesion = nomb_profesion;
	}

}
