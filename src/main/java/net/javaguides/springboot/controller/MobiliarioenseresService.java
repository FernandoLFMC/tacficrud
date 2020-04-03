package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Mobiliarioenseres;
import net.javaguides.springboot.repository.MobiliarioenseresRepository;

@RestController
@RequestMapping("/api/v1/")
public class MobiliarioenseresService {
	
	@Autowired
	private MobiliarioenseresRepository mobiliarioenseresRepository;
	
	@GetMapping("mobiliarioenseres")
	public List<Mobiliarioenseres> getAllMobiliarioenseres(){
		return this.mobiliarioenseresRepository.findAll();
	}

}
