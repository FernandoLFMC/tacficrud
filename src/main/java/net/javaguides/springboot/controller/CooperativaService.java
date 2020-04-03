package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Cooperativa;
import net.javaguides.springboot.repository.CooperativaRepository;

@RestController
@RequestMapping("/api/v1/")
public class CooperativaService {
	
	@Autowired
	private CooperativaRepository cooperativaRepository;
	
	@GetMapping("cooperativa")
	public List<Cooperativa> getAllCooperativas(){
		return this.cooperativaRepository.findAll();
	}

}
