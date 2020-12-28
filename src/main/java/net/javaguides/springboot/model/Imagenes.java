package net.javaguides.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagenes implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "id_imagen")
	private long id_imagen;
	@Column(name = "id_activo")
	private int id_activo;
	@Column(name = "url")
	private String url;
	
	public Imagenes() {
		super();
	}
	
	public Imagenes(long id_imagen, int id_activo, String url) {
		super();
		this.id_imagen = id_imagen;
		this.id_activo = id_activo;
		this.url = url;
	}

	public long getId_imagen() {
		return id_imagen;
	}

	public void setId_imagen(long id_imagen) {
		this.id_imagen = id_imagen;
	}

	public int getId_activo() {
		return id_activo;
	}

	public void setId_activo(int id_activo) {
		this.id_activo = id_activo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Imagenes [id_imagen=" + id_imagen + ", id_activo=" + id_activo + ", url=" + url + "]";
	}
	
	private static final long serialVersionUID = 1L;

}
