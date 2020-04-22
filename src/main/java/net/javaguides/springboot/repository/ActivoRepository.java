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

	   @Query("SELECT new net.javaguides.springboot.dto.SelectActivo(a.nombre_tipo , i.motivo) FROM Activo a JOIN a.info_activo i")
	    public List<SelectActivo> getJoinInformation();
	   
	   @Query("SELECT NEW net.javaguides.springboot.dto.SelectActivo(id_cuenta, cod_tipo, descripcion, unidad )from Activo")
	   public List<SelectActivo> getSelect();
	   
	   
}
