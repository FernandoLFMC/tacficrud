package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Vehiculos;
import net.javaguides.springboot.repository.VehiculosRepository;

@RestController
@RequestMapping("/api/v1/")
public class VehiculosService {
	
	@Autowired
	private VehiculosRepository vehiculosRepository;
	
	@GetMapping("vehiculos")
	public List<Vehiculos> getAllVehiculos(){
		return this.vehiculosRepository.findAll();
	}

}
