package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Seccion;
import net.javaguides.springboot.repository.SeccionRepository;

@RestController
@RequestMapping("/api/v1/")
public class SeccionService {
	
	@Autowired
	private SeccionRepository seccionRepository;
	
	@GetMapping("seccion")
	public List<Seccion> getAllSeccions(){
		return this.seccionRepository.findAll();
	}
	
	@GetMapping("seccion/{id}")
	public ResponseEntity<Seccion> getSeccionById(@PathVariable(value = "id") String seccionId)
			throws ResourceNotFoundException {
		Seccion seccion = seccionRepository.findById(seccionId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + seccionId));
		return ResponseEntity.ok().body(seccion);
	}
	
	@PostMapping("seccion")
	public Seccion createSeccion(@RequestBody Seccion seccion) {
		return seccionRepository.save(seccion);
	}

	@PutMapping("seccion/{id}")
	public ResponseEntity<Seccion> updateSeccion(@PathVariable(value = "id") String seccionId,
			@Valid Seccion seccionDetails) throws ResourceNotFoundException {
		Seccion seccion = seccionRepository.findById(seccionId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + seccionId));

		seccion.setNombre_seccion(seccionDetails.getNombre_seccion());
		return ResponseEntity.ok(this.seccionRepository.save(seccion));
	}

	@DeleteMapping("seccion/{id}")
	public Map<String, Boolean> deleteSeccion(@PathVariable(value = "id") String seccionId)
			throws ResourceNotFoundException {
		Seccion seccion = seccionRepository.findById(seccionId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + seccionId));

		this.seccionRepository.delete(seccion);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
