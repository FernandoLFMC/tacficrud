package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Equiposinstalacion;

@Repository
public interface EquiposinstalacionRepository extends JpaRepository<Equiposinstalacion, Long>{

}
