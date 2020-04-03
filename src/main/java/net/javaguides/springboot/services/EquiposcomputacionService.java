package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Equiposcomputacion;
import net.javaguides.springboot.repository.EquiposcomputacionRepository;

@RestController
@RequestMapping("/api/v1/")
public class EquiposcomputacionService {
	
	@Autowired
	private EquiposcomputacionRepository equiposcomputacionRepository;
	
	@GetMapping("equiposcomputacion")
	public List<Equiposcomputacion> getAllEquiposcomputacions(){
		return this.equiposcomputacionRepository.findAll();
	}

}
