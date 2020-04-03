package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Info_activo;
import net.javaguides.springboot.repository.Info_activoRepository;

@RestController
@RequestMapping("/api/v1/")
public class Info_activoService {
	
	@Autowired
	private Info_activoRepository info_activoRepository;
	
	@GetMapping("info_activo")
	public List<Info_activo> getAllInfo_activos(){
		return this.info_activoRepository.findAll();
	}

}
