package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Adquisicion;

@Repository
public interface AdquisicionRepository extends JpaRepository<Adquisicion, Long>{

}
