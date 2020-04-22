package net.javaguides.springboot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Serializable>{

}
