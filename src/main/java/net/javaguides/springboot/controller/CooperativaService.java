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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
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
	
	@GetMapping("cooperativa/{id}")
	public ResponseEntity<Cooperativa> getCooperativaById(@PathVariable(value = "id") Long cooperativaId)
			throws ResourceNotFoundException {
		Cooperativa cooperativa = cooperativaRepository.findById(cooperativaId)
				.orElseThrow(() -> new ResourceNotFoundException("Cooperativa no encontrada para esta identificacion : : " + cooperativaId));
		return ResponseEntity.ok().body(cooperativa);
	}
	
	@PostMapping("cooperativa")
	public Cooperativa createCooperativa(Cooperativa cooperativa) {
		return cooperativaRepository.save(cooperativa);
	}
	
	@PutMapping("cooperativa/{id}")
	public ResponseEntity<Cooperativa> updateCooperativa(@PathVariable(value = "id") Long cooperativaId,
			@Valid Cooperativa cooperativaDetails) throws ResourceNotFoundException {
		Cooperativa cooperativa = cooperativaRepository.findById(cooperativaId)
				.orElseThrow(() -> new ResourceNotFoundException("Cooperativa no encontrada para esta identificacion : : " + cooperativaId));

		cooperativa.setNombre(cooperativaDetails.getNombre());
		cooperativa.setCiudad(cooperativaDetails.getCiudad());
		cooperativa.setDireccion(cooperativaDetails.getDireccion());
		cooperativa.setTelefono(cooperativaDetails.getTelefono());
		cooperativa.setNit(cooperativaDetails.getNit());
		cooperativa.setCorreo(cooperativaDetails.getCorreo());
		cooperativa.setUrl(cooperativaDetails.getUrl());

		return ResponseEntity.ok(this.cooperativaRepository.save(cooperativa));
	}

	@DeleteMapping("cooperativa/{id}")
	public Map<String, Boolean> deleteCooperativa(@PathVariable(value = "id") Long cooperativaId)
			throws ResourceNotFoundException {
		Cooperativa cooperativa = cooperativaRepository.findById(cooperativaId)
				.orElseThrow(() -> new ResourceNotFoundException("Cooperativa no encontrada para esta identificacion : : " + cooperativaId));

		this.cooperativaRepository.delete(cooperativa);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
