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
import net.javaguides.springboot.model.Edificios;
import net.javaguides.springboot.repository.EdificiosRepository;

@RestController
@RequestMapping("/api/v1/")
public class EdificiosService {
	
	@Autowired
	private EdificiosRepository edificiosRepository;
	
	@GetMapping("edificios")
	public List<Edificios> getAllEdificios(){
		return this.edificiosRepository.findAll();
	}
	@GetMapping("edificios/{id}")
	public ResponseEntity<Edificios> getEdificiosById(@PathVariable(value = "id") Long edificiosId)
			throws ResourceNotFoundException {
		Edificios edificios  = edificiosRepository.findById(edificiosId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + edificiosId));
		return ResponseEntity.ok().body(edificios);
	}
	@PostMapping("edificios")
	public Edificios createEdificios(Edificios edificios) {
		return edificiosRepository.save(edificios);
	}
	@PutMapping("edificios/{id}")
	public ResponseEntity<Edificios> updateEdificios(@PathVariable(value = "id") Long edificiosId,
			@Valid Edificios edificiosDetails) throws ResourceNotFoundException {
		Edificios edificios = edificiosRepository.findById(edificiosId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion no exite para este id :: " + edificiosId));
		edificios.setCiudad(edificiosDetails.getCiudad());
		edificios.setCod_catastro(edificiosDetails.getCod_catastro());
		edificios.setDepartamento(edificiosDetails.getDepartamento());
		edificios.setDireccion(edificiosDetails.getDireccion());
		edificios.setMatricula_ddrr(edificiosDetails.getMatricula_ddrr());
		edificios.setPropietario(edificiosDetails.getPropietario());
		edificios.setSuperficie(edificiosDetails.getSuperficie());

		return ResponseEntity.ok(this.edificiosRepository.save(edificios));
	}
	@DeleteMapping("edificios/{id}")
	public Map<String, Boolean> deleteEdificios(@PathVariable(value = "id") Long edificiosId)
			throws ResourceNotFoundException {
		Edificios edificios = edificiosRepository.findById(edificiosId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion no existe para este id :: " + edificiosId));

		this.edificiosRepository.delete(edificios);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
