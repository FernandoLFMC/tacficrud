package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Equiposcomputacion;

@Repository
public interface EquiposcomputacionRepository extends JpaRepository<Equiposcomputacion, Long>{

}
