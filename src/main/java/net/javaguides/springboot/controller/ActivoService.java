package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Activo;
import net.javaguides.springboot.repository.ActivoRepository;

@RestController
@RequestMapping("/api/v1/")
public class ActivoService {
	
	@Autowired
	private ActivoRepository activoRepository;
	
	@GetMapping("activo")
	public List<Activo> getAllActivos(){
		return this.activoRepository.findAll();
	}

}
