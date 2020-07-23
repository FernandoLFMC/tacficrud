package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Cuenta;
import net.javaguides.springboot.repository.CuentaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class CuentaService {
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@GetMapping("cuenta")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('PM')")
	public List<Cuenta> getAllCuentas(){
		return this.cuentaRepository.findAll();
	}
	
	@GetMapping("cuenta/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Cuenta> getCuentaById(@PathVariable(value = "id") Long cuentaId)
			throws ResourceNotFoundException {
		Cuenta cuenta = cuentaRepository.findById(cuentaId)
				.orElseThrow(() -> new ResourceNotFoundException("Cuenta no existe para este id :: " + cuentaId));
		return ResponseEntity.ok().body(cuenta);
	}


	@PostMapping("cuenta")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}


	@PutMapping("cuenta/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Cuenta> updateCuenta(@PathVariable(value = "id") Long cuentaId,
			@Valid @RequestBody Cuenta CuentaDetails) throws ResourceNotFoundException {
		Cuenta cuenta = cuentaRepository.findById(cuentaId)
				.orElseThrow(() -> new ResourceNotFoundException("Cuenta no existe para este id :: " + cuentaId));

		cuenta.setDescripcion_cuenta(CuentaDetails.getDescripcion_cuenta());
		return ResponseEntity.ok(this.cuentaRepository.save(cuenta));
	}

	
	@DeleteMapping("cuenta/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Map<String, Boolean> deleteCuenta(@PathVariable(value = "id") Long cuentaId)
			throws ResourceNotFoundException {
		Cuenta cuenta= cuentaRepository.findById(cuentaId)
				.orElseThrow(() -> new ResourceNotFoundException("Cuenta no existe para este id :: " + cuentaId));

		this.cuentaRepository.delete(cuenta);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
