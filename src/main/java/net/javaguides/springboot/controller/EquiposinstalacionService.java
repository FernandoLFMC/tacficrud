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
import net.javaguides.springboot.model.Equiposinstalacion;
import net.javaguides.springboot.repository.EquiposinstalacionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class EquiposinstalacionService {
	
	@Autowired
	private EquiposinstalacionRepository equiposinstalacionRepository;
	
	@GetMapping("equiposinstalacion")
	public List<Equiposinstalacion> getAllEquiposinstalacions(){
		return this.equiposinstalacionRepository.findAll();
	}
	
	@GetMapping("equiposinstalacion/{id}")
	public ResponseEntity<Equiposinstalacion> getEquiposinstalacionById(@PathVariable(value = "id") Long equiposinstalacionId)
			throws ResourceNotFoundException {
		Equiposinstalacion equiposinstalacion = equiposinstalacionRepository.findById(equiposinstalacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + equiposinstalacionId));
		return ResponseEntity.ok().body(equiposinstalacion);
	}
	
	@PostMapping("equiposinstalacion")
	@PreAuthorize("hasRole('ADMIN')")
	public Equiposinstalacion createEquiposinstalacion(@RequestBody Equiposinstalacion equiposinstalacion) {
		return equiposinstalacionRepository.save(equiposinstalacion);
	}

	@PutMapping("equiposinstalacion/{id}")
	public ResponseEntity<Equiposinstalacion> updateEquiposinstalacion(@PathVariable(value = "id") Long equiposinstalacionId,
			@Valid @RequestBody Equiposinstalacion equiposinstalacionDetails) throws ResourceNotFoundException {
		Equiposinstalacion equiposinstalacion = equiposinstalacionRepository.findById(equiposinstalacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + equiposinstalacionId));

		equiposinstalacion.setColor(equiposinstalacionDetails.getColor());
		equiposinstalacion.setId_activo(equiposinstalacion.getId_activo());
		equiposinstalacion.setIndustria(equiposinstalacionDetails.getIndustria());
		equiposinstalacion.setMarca(equiposinstalacionDetails.getMarca());
		equiposinstalacion.setModelo(equiposinstalacionDetails.getModelo());
		equiposinstalacion.setNro_serial(equiposinstalacionDetails.getNro_serial());
		equiposinstalacion.setTipo(equiposinstalacionDetails.getTipo());
		return ResponseEntity.ok(this.equiposinstalacionRepository.save(equiposinstalacion));
	}

	@DeleteMapping("equiposinstalacion/{id}")
	public Map<String, Boolean> deleteEquiposinstalacion(@PathVariable(value = "id") Long equiposinstalacionId)
			throws ResourceNotFoundException {
		Equiposinstalacion equiposinstalacion = equiposinstalacionRepository.findById(equiposinstalacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + equiposinstalacionId));

		this.equiposinstalacionRepository.delete(equiposinstalacion);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
