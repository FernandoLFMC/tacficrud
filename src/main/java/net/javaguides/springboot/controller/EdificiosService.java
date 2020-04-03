package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Edificios;
import net.javaguides.springboot.repository.EdificiosRepository;

@RestController
@RequestMapping("/api/v1/")
public class EdificiosService {
	
	@Autowired
	private EdificiosRepository edificiosRepository;
	
	@GetMapping("edificios")
	public List<Edificios> getAllEdificios(){
		return this.edificiosRepository.findAll();
	}

}
