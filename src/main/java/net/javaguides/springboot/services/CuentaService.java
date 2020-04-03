package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Cuenta;
import net.javaguides.springboot.repository.CuentaRepository;

@RestController
@RequestMapping("/api/v1/")
public class CuentaService {
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@GetMapping("cuenta")
	public List<Cuenta> getAllCuentas(){
		return this.cuentaRepository.findAll();
	}

}
