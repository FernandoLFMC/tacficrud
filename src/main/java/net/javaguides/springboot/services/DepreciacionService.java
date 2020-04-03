package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Depreciacion;
import net.javaguides.springboot.repository.DepreciacionRepository;

@RestController
@RequestMapping("/api/v1/")
public class DepreciacionService {
	
	@Autowired
	private DepreciacionRepository depreciacionRepository;
	
	@GetMapping("depreciacion")
	public List<Depreciacion> getAllDepreciacions(){
		return this.depreciacionRepository.findAll();
	}

}
