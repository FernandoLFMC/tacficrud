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
import net.javaguides.springboot.model.Profesion;
import net.javaguides.springboot.repository.ProfesionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ProfesionService {
	@Autowired
	private ProfesionRepository profesionRepository;
	

	@GetMapping("profesion")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public List<Profesion> getAllProfesions(){
		return this.profesionRepository.findAll();
	}
	
	@GetMapping("profesion/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Profesion> getProfesionById(@PathVariable(value = "id") Long profesionId)
		throws ResourceNotFoundException{
		Profesion profesion = profesionRepository.findById(profesionId)
				.orElseThrow(()-> new ResourceNotFoundException("Profesion no encontrada para esta identificacion : : "+ profesionId));
		return ResponseEntity.ok().body(profesion);
	}
	
	@PostMapping("profesion")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Profesion creatProfesion(@RequestBody Profesion profesion) {
		return profesionRepository.save(profesion);
	}
	
	@PutMapping("profesion/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Profesion> updateProfesion(@PathVariable(value = "id") Long profesionId,
			@Valid Profesion profesionDetails) throws ResourceNotFoundException {
		Profesion profesion = profesionRepository.findById(profesionId)
				.orElseThrow(() -> new ResourceNotFoundException("Profesion no identificada para esta identificacion :: " + profesionId));

		profesion.setNomb_profesion(profesionDetails.getNomb_profesion());
		
		return ResponseEntity.ok(this.profesionRepository.save(profesion));
	}
	
	@DeleteMapping("profesion/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Map<String, Boolean> deleteProfesion(@PathVariable(value = "id") Long profesionId)
			throws ResourceNotFoundException {
		Profesion profesion = profesionRepository.findById(profesionId)
				.orElseThrow(() -> new ResourceNotFoundException("Profesion no identificada para esta identificacion :: " + profesionId));

		this.profesionRepository.delete(profesion);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
