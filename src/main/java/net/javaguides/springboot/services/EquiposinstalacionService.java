package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Equiposinstalacion;
import net.javaguides.springboot.repository.EquiposinstalacionRepository;

@RestController
@RequestMapping("/api/v1/")
public class EquiposinstalacionService {
	
	@Autowired
	private EquiposinstalacionRepository equiposinstalacionRepository;
	
	@GetMapping("equiposinstalacion")
	public List<Equiposinstalacion> getAllEquiposinstalacions(){
		return this.equiposinstalacionRepository.findAll();
	}

}
