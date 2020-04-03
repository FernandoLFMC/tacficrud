package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Terrenos;
import net.javaguides.springboot.repository.TerrenosRepository;

@RestController
@RequestMapping("/api/v1/")
public class TerrenosService {
	
	@Autowired
	private TerrenosRepository terrenosRepository;
	
	@GetMapping("terrenos")
	public List<Terrenos> getAllTerrenos(){
		return this.terrenosRepository.findAll();
	}
	

}
