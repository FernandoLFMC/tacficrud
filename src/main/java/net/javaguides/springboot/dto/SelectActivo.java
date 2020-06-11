package net.javaguides.springboot.dto;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SelectActivo {
	
	private long id_activo;
	private int id_cuenta;
	private int id_coop;
	private int cod_tipo;
	private String cod_seccion;
	private String id_funcionario;
	private String nombre_tipo;
	private String descripcion;
	private String unidad;
	private String observacion;
	private long id_info;
	private String funcionario_anterior;
	private String seccion_anterior;
	private Date fecha_movimiento;
	private String estado_op_nop;
	private String motivo;
	
    public SelectActivo(int cod_tipo,int id_cuenta,String funcionario_anterior, String seccion_anterior,Date fecha_movimiento,String motivo,String id_funcionario,String cod_seccion) {
        this.cod_tipo= cod_tipo;
        this.id_cuenta=id_cuenta;
        this.funcionario_anterior=funcionario_anterior;
        this.seccion_anterior=seccion_anterior;
        this.fecha_movimiento=fecha_movimiento;
        this.id_funcionario=id_funcionario;
        this.motivo=motivo;
        this.cod_seccion=cod_seccion;
    }
	

	public SelectActivo(long id_activo, int id_cuenta, int id_coop, int cod_tipo, String cod_seccion, String id_funcionario) {
		super();
		this.id_activo = id_activo;
		this.id_cuenta = id_cuenta;
		this.id_coop = id_coop;
		this.cod_tipo = cod_tipo;
		this.cod_seccion = cod_seccion;
		this.id_funcionario = id_funcionario;
	}
	
	public SelectActivo(long id_activo, int id_cuenta, int cod_tipo) {
		this.id_activo = id_activo;
		this.id_cuenta = id_cuenta;
		this.cod_tipo = cod_tipo;
	}




	public int getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public int getId_coop() {
		return id_coop;
	}

	public void setId_coop(int id_coop) {
		this.id_coop = id_coop;
	}

	public int getCod_tipo() {
		return cod_tipo;
	}

	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
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

	public long getId_info() {
		return id_info;
	}

	public void setId_info(long id_info) {
		this.id_info = id_info;
	}

	public long getId_activo() {
		return id_activo;
	}

	public void setId_activo(long id_activo) {
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
	

	

	
	
	
}
