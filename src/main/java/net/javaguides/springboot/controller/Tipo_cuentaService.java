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
import net.javaguides.springboot.model.tipo_cuenta;
import net.javaguides.springboot.repository.Tipo_cuentaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class Tipo_cuentaService {
	@Autowired
	private Tipo_cuentaRepository tipo_cuentaRepository;
	
	@GetMapping("tipo_cuenta")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public List<tipo_cuenta> getAllTipo_cuentas(){
		return this.tipo_cuentaRepository.findAll();
	}
	
	@GetMapping("tipo_cuenta/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<tipo_cuenta> getTipo_cuentaById(@PathVariable(value = "id") Long tipo_cuentaId)
			throws ResourceNotFoundException {
		tipo_cuenta tipo_cuenta = tipo_cuentaRepository.findById(tipo_cuentaId)
				.orElseThrow(() -> new ResourceNotFoundException("Informacion de Tipo de cuenta no existe para este id :: " + tipo_cuentaId));
		return ResponseEntity.ok().body(tipo_cuenta);
	}


	@PostMapping("tipo_cuenta")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public tipo_cuenta createEmployee(@RequestBody tipo_cuenta tipo_cuenta) {
		return tipo_cuentaRepository.save(tipo_cuenta);
	}


	@PutMapping("tipo_cuenta/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<tipo_cuenta> updateTipo_cuenta(@PathVariable(value = "id") Long tipo_cuentaId,
			@Valid @RequestBody tipo_cuenta tipo_cuentaDetails) throws ResourceNotFoundException {
				tipo_cuenta tipo_cuenta = tipo_cuentaRepository.findById(tipo_cuentaId)
				.orElseThrow(() -> new ResourceNotFoundException("Informacion de Tipo de cuenta no existe para este id :: " + tipo_cuentaId));


		tipo_cuenta.setId_cuenta(tipo_cuentaDetails.getId_cuenta());
		tipo_cuenta.setNum(tipo_cuentaDetails.getNum());
		tipo_cuenta.setNombre(tipo_cuentaDetails.getNombre());
		return ResponseEntity.ok(this.tipo_cuentaRepository.save(tipo_cuenta));
	}


	@DeleteMapping("tipo_cuenta/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Map<String, Boolean> deleteTipo_cuenta(@PathVariable(value = "id") Long tipo_cuentaId)
			throws ResourceNotFoundException {
		tipo_cuenta tipo_cuenta = tipo_cuentaRepository.findById(tipo_cuentaId)
				.orElseThrow(() -> new ResourceNotFoundException("Informacion de Tipo de cuenta no existe para este id :: " + tipo_cuentaId));

		this.tipo_cuentaRepository.delete(tipo_cuenta);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
