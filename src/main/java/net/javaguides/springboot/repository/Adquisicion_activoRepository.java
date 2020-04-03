package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Adquisicion_activo;

@Repository
public interface Adquisicion_activoRepository extends JpaRepository<Adquisicion_activo, Long>{

}
