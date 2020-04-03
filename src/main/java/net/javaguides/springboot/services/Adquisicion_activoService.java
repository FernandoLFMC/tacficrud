package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Adquisicion_activo;
import net.javaguides.springboot.repository.Adquisicion_activoRepository;

@RestController
@RequestMapping("/api/v1/")
public class Adquisicion_activoService {
	
	@Autowired
	private Adquisicion_activoRepository adquisicion_activoRepository;
	
	@GetMapping("adquisicion_activo")
	public List<Adquisicion_activo> getAllAdquisicion_activos(){
		return this.adquisicion_activoRepository.findAll();
	}

}
