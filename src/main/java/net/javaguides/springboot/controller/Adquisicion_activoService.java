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
import net.javaguides.springboot.model.Adquisicion_activo;
import net.javaguides.springboot.repository.Adquisicion_activoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class Adquisicion_activoService {
	
	@Autowired
	private Adquisicion_activoRepository adquisicion_activoRepository;
	
	@GetMapping("/adquisicion_activo")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Adquisicion_activo> getAllAdquisicion_activos(){
		return this.adquisicion_activoRepository.findAll();
	}
	

	@GetMapping("/adquisicion_activo/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Adquisicion_activo> getAdquisicion_activoById(@PathVariable(value = "id") Long adquisicion_activoId)
			throws ResourceNotFoundException {
		Adquisicion_activo adquisicion_activo = adquisicion_activoRepository.findById(adquisicion_activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion activo no existe para este id :: " + adquisicion_activoId));
		return ResponseEntity.ok().body(adquisicion_activo);
	}


	@PostMapping("/adquisicion_activo")
	@PreAuthorize("hasRole('ADMIN')")
	public Adquisicion_activo createAdquisicion_activo(@RequestBody Adquisicion_activo adquisicion_activo) {
		return adquisicion_activoRepository.save(adquisicion_activo);
	}

	//update employee 
	@PutMapping("/adquisicion_activo/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Adquisicion_activo> updateAdquisicion_activo(@PathVariable(value = "id") Long adquisicion_activoId,
			@Valid @RequestBody Adquisicion_activo adquisicion_activoDetails) throws ResourceNotFoundException {
		Adquisicion_activo adquisicion_activo = adquisicion_activoRepository.findById(adquisicion_activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion activo no existe para este id :: " + adquisicion_activoId));

		adquisicion_activo.setFecha_adquisicion(adquisicion_activoDetails.getFecha_adquisicion());
		adquisicion_activo.setComprobante_contable(adquisicion_activoDetails.getComprobante_contable());
		adquisicion_activo.setCosto_adquisicion(adquisicion_activoDetails.getCosto_adquisicion());
		return ResponseEntity.ok(this.adquisicion_activoRepository.save(adquisicion_activo));
	}

	//delete employee
	@DeleteMapping("/adquisicion_activo/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteAdquisicion_activo(@PathVariable(value = "id") Long adquisicion_activoId)
			throws ResourceNotFoundException {
		Adquisicion_activo adquisicion_activo = adquisicion_activoRepository.findById(adquisicion_activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion_activo id :: " + adquisicion_activoId));

		this.adquisicion_activoRepository.delete(adquisicion_activo);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
