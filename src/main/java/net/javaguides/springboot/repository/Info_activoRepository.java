package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Info_activo;

@Repository
public interface Info_activoRepository extends JpaRepository<Info_activo, Long>{

}
