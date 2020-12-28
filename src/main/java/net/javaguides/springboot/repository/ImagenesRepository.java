package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Imagenes;

@Repository
public interface ImagenesRepository extends JpaRepository<Imagenes, Long>{

}
