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
import net.javaguides.springboot.model.Equiposcomputacion;
import net.javaguides.springboot.repository.EquiposcomputacionRepository;

@RestController
@RequestMapping("/api/v1/")
public class EquiposcomputacionService {
	
	@Autowired
	private EquiposcomputacionRepository equiposcomputacionRepository;
	
	@GetMapping("equiposcomputacion")
	public List<Equiposcomputacion> getAllEquiposcomputacions(){
		return this.equiposcomputacionRepository.findAll();
	}
	@GetMapping("equiposcomputacion/{id}")
	public ResponseEntity<Equiposcomputacion> getEquiposcomputacionById(@PathVariable(value = "id") Long equiposcomputacionId)
			throws ResourceNotFoundException {
		Equiposcomputacion equiposcomputacion  = equiposcomputacionRepository.findById(equiposcomputacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + equiposcomputacionId));
		return ResponseEntity.ok().body(equiposcomputacion);
	}
	@PostMapping("equiposcomputacion")
	public Equiposcomputacion createEquiposcomputacion(Equiposcomputacion equiposcomputacion) {
		return equiposcomputacionRepository.save(equiposcomputacion);
	}
	@PutMapping("equiposcomputacion/{id}")
	public ResponseEntity<Equiposcomputacion> updateEquiposcomputacion(@PathVariable(value = "id") Long equiposcomputacionId,
			@Valid Equiposcomputacion equiposcomputacionDetails) throws ResourceNotFoundException {
		Equiposcomputacion equiposcomputacion = equiposcomputacionRepository.findById(equiposcomputacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion no exite para este id :: " + equiposcomputacionId));
		
		equiposcomputacion.setMarca(equiposcomputacionDetails.getMarca());
		equiposcomputacion.setNro_serial(equiposcomputacionDetails.getNro_serial());
		equiposcomputacion.setColor(equiposcomputacionDetails.getColor());
		equiposcomputacion.setTipo(equiposcomputacionDetails.getTipo());
		equiposcomputacion.setIndustria(equiposcomputacionDetails.getIndustria());

		return ResponseEntity.ok(this.equiposcomputacionRepository.save(equiposcomputacion));
	}
	@DeleteMapping("equiposcomputacion/{id}")
	public Map<String, Boolean> deleteequiposcomputacion(@PathVariable(value = "id") Long equiposcomputacionId)
			throws ResourceNotFoundException {
		Equiposcomputacion equiposcomputacion = equiposcomputacionRepository.findById(equiposcomputacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion no existe para este id :: " + equiposcomputacionId));

		this.equiposcomputacionRepository.delete(equiposcomputacion);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
