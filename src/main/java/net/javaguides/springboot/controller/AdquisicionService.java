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
import net.javaguides.springboot.model.Adquisicion;
import net.javaguides.springboot.repository.AdquisicionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class AdquisicionService {
	
	@Autowired
	private AdquisicionRepository adquisicionRepository;
	
	@GetMapping("adquisicion")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('PM')")
	public List<Adquisicion> getAllAdquisicions(){
		return this.adquisicionRepository.findAll();
	}
	

	@GetMapping("adquisicion/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Adquisicion> getAdquisicionById(@PathVariable(value = "id") String adquisicionId)
			throws ResourceNotFoundException {
		Adquisicion adquisicion = adquisicionRepository.findById(adquisicionId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisiscion no existe para este id :: " + adquisicionId));
		return ResponseEntity.ok().body(adquisicion);
	}


	@PostMapping("adquisicion")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Adquisicion createAdquisiscion(@RequestBody Adquisicion adquisicion) {
		return adquisicionRepository.save(adquisicion);
	}

	
	@PutMapping("adquisicion/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Adquisicion> updateAdquisicion(@PathVariable(value = "id") String adquisicionId,
			@Valid @RequestBody Adquisicion adquisicionDetails) throws ResourceNotFoundException {
		Adquisicion adquisicion = adquisicionRepository.findById(adquisicionId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion no exite para este id :: " + adquisicionId));

		adquisicion.setPorcentaje(adquisicionDetails.getPorcentaje());
		adquisicion.setNombre_tipo_adq(adquisicionDetails.getNombre_tipo_adq());
		return ResponseEntity.ok(this.adquisicionRepository.save(adquisicion));
	}

	//delete employee
	@DeleteMapping("adquisicion/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Map<String, Boolean> deleteAdquisicion(@PathVariable(value = "id") String adquisicionId)
			throws ResourceNotFoundException {
		Adquisicion adquisicion = adquisicionRepository.findById(adquisicionId)
				.orElseThrow(() -> new ResourceNotFoundException("Adquisicion no existe para este id :: " + adquisicionId));

		this.adquisicionRepository.delete(adquisicion);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
