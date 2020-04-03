package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Proveedor;
import net.javaguides.springboot.repository.ProveedorRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("proveedor")
	public List<Proveedor> getAllProveedors(){
		return this.proveedorRepository.findAll();
	}

}
