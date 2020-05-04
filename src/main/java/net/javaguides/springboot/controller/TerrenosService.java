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
import net.javaguides.springboot.model.Terrenos;
import net.javaguides.springboot.repository.TerrenosRepository;

@RestController
@RequestMapping("/api/v1/")
public class TerrenosService {
	
	@Autowired
	private TerrenosRepository terrenosRepository;
	
	@GetMapping("terrenos")
	public List<Terrenos> getAllTerrenos(){
		return this.terrenosRepository.findAll();
	}
	
	@GetMapping("terrenos/{id}")
	public ResponseEntity<Terrenos> getTerrenosById(@PathVariable(value = "id") Long terrenosId)
			throws ResourceNotFoundException {
		Terrenos terrenos = terrenosRepository.findById(terrenosId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no encontrado para esta identificacion : : " + terrenosId));
		return ResponseEntity.ok().body(terrenos);
	}
	
	@PostMapping("terrenos")
	public Terrenos createTerrenos(Terrenos terrenos) {
		return terrenosRepository.save(terrenos);
	}

	@PutMapping("terrenos/{id}")
	public ResponseEntity<Terrenos> updateTerrenos(@PathVariable(value = "id") Long terrenosId,
			@Valid Terrenos terrenosDetails) throws ResourceNotFoundException {
		Terrenos terrenos = terrenosRepository.findById(terrenosId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + terrenosId));

		terrenos.setCiudad(terrenosDetails.getCiudad());
		terrenos.setDepartamento(terrenosDetails.getDepartamento());
		terrenos.setDireccion(terrenosDetails.getDireccion());
		terrenos.setMatricula_ddrr(terrenosDetails.getMatricula_ddrr());
		terrenos.setPropietario(terrenosDetails.getPropietario());
		terrenos.setSuperficie(terrenosDetails.getSuperficie());
		terrenos.setCod_catastro(terrenosDetails.getCod_catastro());
		
		
		
		return ResponseEntity.ok(this.terrenosRepository.save(terrenos));
	}

	@DeleteMapping("terrenos/{id}")
	public Map<String, Boolean> deleteEquiposinstalacion(@PathVariable(value = "id") Long terrenosId)
			throws ResourceNotFoundException {
		Terrenos terrenos = terrenosRepository.findById(terrenosId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + terrenosId));

		this.terrenosRepository.delete(terrenos);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
