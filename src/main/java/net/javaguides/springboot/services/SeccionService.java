package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Seccion;
import net.javaguides.springboot.repository.SeccionRepository;

@RestController
@RequestMapping("/api/v1/")
public class SeccionService {
	
	@Autowired
	private SeccionRepository seccionRepository;
	
	@GetMapping("seccion")
	public List<Seccion> getAllSeccions(){
		return this.seccionRepository.findAll();
	}
	

}
