package net.javaguides.springboot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.dto.SelectActivo;
import net.javaguides.springboot.model.Activo;

@Repository
public interface ActivoRepository extends JpaRepository<Activo, Serializable>{

	   @Query("SELECT new net.javaguides.springboot.dto.SelectActivo(a.cod_tipo,a.id_cuenta,i.funcionario_anterior, i.seccion_anterior, i.fecha_movimiento,i.motivo, a.id_funcionario,a.cod_seccion) FROM Activo a JOIN a.info_activo i")
	    public List<SelectActivo> getJoinInformation();
	   
	   @Query("SELECT NEW net.javaguides.springboot.dto.SelectActivo(id_activo,id_cuenta, id_coop, cod_tipo, cod_seccion, id_funcionario, nombre_tipo, unidad, descripcion, observacion, estado_op_nop )from Activo")
	   public List<SelectActivo> getSelect();
	   
	   @Query("SELECT NEW net.javaguides.springboot.dto.SelectActivo(id_activo, id_cuenta, cod_tipo)from Activo")
	   public List<SelectActivo> getIdActivo();
	   
	   
}
