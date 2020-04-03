package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Depreciacion;

@Repository
public interface DepreciacionRepository extends JpaRepository<Depreciacion, Long>{

}
