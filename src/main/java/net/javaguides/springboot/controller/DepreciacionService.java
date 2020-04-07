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
import net.javaguides.springboot.model.Depreciacion;
import net.javaguides.springboot.repository.DepreciacionRepository;

@RestController
@RequestMapping("/api/v1/")
public class DepreciacionService {
	
	@Autowired
	private DepreciacionRepository depreciacionRepository;
	
	@GetMapping("depreciacion")
	public List<Depreciacion> getAllDepreciacions(){
		return this.depreciacionRepository.findAll();
	}
	

	@GetMapping("depreciacion/{id}")
	public ResponseEntity<Depreciacion> getDepreciacionById(@PathVariable(value = "id") Long depreciacionId)
			throws ResourceNotFoundException {
		Depreciacion depreciacion = depreciacionRepository.findById(depreciacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Depreciacion no existe para este id :: " + depreciacionId));
		return ResponseEntity.ok().body(depreciacion);
	}


	@PostMapping("depreciacion")
	public Depreciacion createDepreciacion(Depreciacion depreciacion) {
		return depreciacionRepository.save(depreciacion);
	}

	
	@PutMapping("depreciacion/{id}")
	public ResponseEntity<Depreciacion> updateDepreciacion(@PathVariable(value = "id") Long depreciacionId,
			@Valid Depreciacion depreciacionDetails) throws ResourceNotFoundException {
		Depreciacion depreciacion = depreciacionRepository.findById(depreciacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Depreciacion no existe para este id :: " + depreciacionId));

		depreciacion.setDepreciacion_mensual(depreciacionDetails.getDepreciacion_mensual());
		return ResponseEntity.ok(this.depreciacionRepository.save(depreciacion));
	}


	@DeleteMapping("depreciacion/{id}")
	public Map<String, Boolean> deleteDepreciacion(@PathVariable(value = "id") Long depreciacionId)
			throws ResourceNotFoundException {
		Depreciacion depreciacion = depreciacionRepository.findById(depreciacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Depreciacion no existe para este id :: " + depreciacionId));

		this.depreciacionRepository.delete(depreciacion);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
