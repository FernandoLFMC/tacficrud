package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Adquisicion;
import net.javaguides.springboot.repository.AdquisicionRepository;

@RestController
@RequestMapping("/api/v1/")
public class AdquisicionService {
	
	@Autowired
	private AdquisicionRepository adquisicionRepository;
	
	@GetMapping("adquisicion")
	public List<Adquisicion> getAllAdquisicions(){
		return this.adquisicionRepository.findAll();
	}

}
