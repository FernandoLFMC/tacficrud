package net.javaguides.springboot.dto;


import java.sql.Date;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SelectActivo {
	
	private int id_cuenta;
	private int cod_tipo;
	private String nombre_tipo;
	private String descripcion;
	private String unidad;
	private String observacion;
	private int id_activo;
	private int id_coop;
	private String cod_seccion;
	private String id_funcionario;
	private Date fecha_movimiento;
	private String estado_op_nop;
	private String motivo;
	
    public SelectActivo(String nombre_tipo, String cod_seccion) {
        this.nombre_tipo=nombre_tipo;
        this.cod_seccion= cod_seccion;
    }
	
    public SelectActivo(int id_cuenta, int cod_tipo, String descripcion, String unidad) {
        this.id_cuenta=id_cuenta;
        this.cod_tipo=cod_tipo;
        this.descripcion=descripcion;
        this.unidad=unidad;
    }
	
	public int getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public int getCod_tipo() {
		return cod_tipo;
	}
	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
	}
	public String getNombre_tipo() {
		return nombre_tipo;
	}
	public void setNombre_tipo(String nombre_tipo) {
		this.nombre_tipo = nombre_tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	

	
	
	
}
