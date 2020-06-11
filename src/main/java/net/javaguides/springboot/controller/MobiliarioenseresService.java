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
import net.javaguides.springboot.model.Mobiliarioenseres;
import net.javaguides.springboot.repository.MobiliarioenseresRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class MobiliarioenseresService {
	
	@Autowired
	private MobiliarioenseresRepository mobiliarioenseresRepository;
	
	@GetMapping("mobiliarioenseres")
	public List<Mobiliarioenseres> getAllMobiliarioenseres(){
		return this.mobiliarioenseresRepository.findAll();
	}
	
	@GetMapping("mobiliarioenseres/{id}")
	public ResponseEntity<Mobiliarioenseres> getMobiliarioenseresById(@PathVariable(value = "id") Long mobiliarioenseresId)
			throws ResourceNotFoundException {
		Mobiliarioenseres mobiliarioenseres = mobiliarioenseresRepository.findById(mobiliarioenseresId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + mobiliarioenseresId));
		return ResponseEntity.ok().body(mobiliarioenseres);
	}
	
	@PostMapping("mobiliarioenseres")
	@PreAuthorize("hasRole('ADMIN')")
	public Mobiliarioenseres createMobiliarioenseres(@RequestBody Mobiliarioenseres mobiliarioenseres) {
		return mobiliarioenseresRepository.save(mobiliarioenseres);
	}

	@PutMapping("mobiliarioenseres/{id}")
	public ResponseEntity<Mobiliarioenseres> updateMobiliarioenseres(@PathVariable(value = "id") Long mobiliarioenseresId,
			@Valid @RequestBody Mobiliarioenseres mobiliarioenseresDetails) throws ResourceNotFoundException {
		Mobiliarioenseres mobiliarioenseres = mobiliarioenseresRepository.findById(mobiliarioenseresId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + mobiliarioenseresId));

		
		mobiliarioenseres.setColor(mobiliarioenseresDetails.getColor());
		mobiliarioenseres.setId_activo(mobiliarioenseresDetails.getId_activo());
		mobiliarioenseres.setMaterial(mobiliarioenseresDetails.getMaterial());
		return ResponseEntity.ok(this.mobiliarioenseresRepository.save(mobiliarioenseres));
	}

	@DeleteMapping("mobiliarioenseres/{id}")
	public Map<String, Boolean> deleteMobiliarioenseres(@PathVariable(value = "id") Long mobiliarioenseresId)
			throws ResourceNotFoundException {
		Mobiliarioenseres mobiliarioenseres = mobiliarioenseresRepository.findById(mobiliarioenseresId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + mobiliarioenseresId));

		this.mobiliarioenseresRepository.delete(mobiliarioenseres);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
