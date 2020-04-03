package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Edificios;

@Repository
public interface EdificiosRepository extends JpaRepository<Edificios, Long>{

}
