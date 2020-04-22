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
import net.javaguides.springboot.model.Activo;
import net.javaguides.springboot.model.Cuenta;
import net.javaguides.springboot.repository.ActivoRepository;
import net.javaguides.springboot.repository.CuentaRepository;

@RestController
@RequestMapping("/api/v1/")
public class ActivoService {
	
	@Autowired
	private ActivoRepository activoRepository;
	@Autowired
	private CuentaRepository cuentaRepository;
	

	
	@GetMapping("activo")
	public List<Activo> getAllActivos(Activo acivo){
		return this.activoRepository.findAll();
	}
	

	@GetMapping("activoo")
	public List<Cuenta> getAllCuentas(){
		return this.cuentaRepository.findAll();
	}
	
	

	@GetMapping("activo/{id}")
	public ResponseEntity<Activo> getActivoById(@PathVariable(value = "id") Long activoId)
			throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));
		return ResponseEntity.ok().body(activo);
	}
	
	
	/*@GetMapping("activ/{id}")
	public ResponseEntity<Optional<Activo>> getActivById(@PathVariable(value = "id") Long activoId)
			{
		Optional<Activo> activo = activoRepository.findById(activoId);
		if(activo.isPresent())
			return ResponseEntity.ok().body(activo);
		else
			return null ;

	}*/

	@PostMapping("activo")
	public Activo createActivo( Activo activo) {
		return activoRepository.save(activo);
	}

 
	@PutMapping("activo/{id}")
	public ResponseEntity<Activo> updateActivo(@PathVariable(value = "id") Long activoId,
			@Valid Activo activoDetails) throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));


		activo.setId_cuenta(activoDetails.getId_cuenta());
		activo.setCod_tipo(activoDetails.getCod_tipo());
		activo.setCod_seccion(activoDetails.getCod_seccion());
		activo.setId_funcionario(activoDetails.getId_funcionario());
		activo.setNombre_tipo(activoDetails.getNombre_tipo());
		activo.setDescripcion(activoDetails.getDescripcion());
		activo.setUnidad(activoDetails.getUnidad());
		activo.setObservacion(activoDetails.getObservacion());
		return ResponseEntity.ok(this.activoRepository.save(activo));
	}


	@DeleteMapping("activo/{id}")
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
