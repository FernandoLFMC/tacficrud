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
import net.javaguides.springboot.model.Activo;
import net.javaguides.springboot.repository.ActivoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ActivoService {
	
	@Autowired
	private ActivoRepository activoRepository;

	

	
	@GetMapping("/activo")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Activo> getAllActivos(Activo acivo){
		return this.activoRepository.findAll();
	}

	@GetMapping("/activo/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Activo> getActivoById(@PathVariable(value = "id") Long activoId)
			throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));
		return ResponseEntity.ok().body(activo);
	}
	

	@PostMapping("/activo")
	@PreAuthorize("hasRole('ADMIN')")
	public Activo createActivo( @RequestBody Activo activo) {
		return activoRepository.save(activo);
	}

 
	@PutMapping("/activo/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Activo> updateActivo(@PathVariable(value = "id") Long activoId,
			@Valid @RequestBody Activo activoDetails) throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));


		activo.setId_cuenta(activoDetails.getId_cuenta());
		activo.setCod_tipo(activoDetails.getCod_tipo());
		activo.setCod_seccion(activoDetails.getCod_seccion());
		activo.setId_funcionario(activoDetails.getId_funcionario());
		activo.setNombre_tipo(activoDetails.getNombre_tipo());
		activo.setDescripcion(activoDetails.getDescripcion());
		activo.setUnidad(activoDetails.getUnidad());
		activo.setEstado_op_nop(activoDetails.getEstado_op_nop());
		activo.setObservacion(activoDetails.getObservacion());
		return ResponseEntity.ok(this.activoRepository.save(activo));
	}


	@DeleteMapping("activo/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteActivo(@PathVariable(value = "id") Long activoId)
			throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));

		this.activoRepository.delete(activo);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
