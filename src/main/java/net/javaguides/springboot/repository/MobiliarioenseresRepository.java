package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Mobiliarioenseres;

@Repository
public interface MobiliarioenseresRepository extends JpaRepository<Mobiliarioenseres, Long>{

}
