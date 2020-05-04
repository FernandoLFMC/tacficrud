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
import net.javaguides.springboot.model.Info_activo;
import net.javaguides.springboot.repository.Info_activoRepository;

@RestController
@RequestMapping("/api/v1/")
public class Info_activoService {
	
	@Autowired
	private Info_activoRepository info_activoRepository;
	
	@GetMapping("info_activo")
	public List<Info_activo> getAllInfo_activos(){
		return this.info_activoRepository.findAll();
	}


	@GetMapping("info_activo/{id}")
	public ResponseEntity<Info_activo> getInfo_activoById(@PathVariable(value = "id") Long info_activoId)
			throws ResourceNotFoundException {
		Info_activo info_activo = info_activoRepository.findById(info_activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Informacion de activo no existe para este id :: " + info_activoId));
		return ResponseEntity.ok().body(info_activo);
	}


	@PostMapping("info_activo")
	public Info_activo createEmployee(Info_activo info_activo) {
		return info_activoRepository.save(info_activo);
	}


	@PutMapping("info_activo/{id}")
	public ResponseEntity<Info_activo> updateInfo_activo(@PathVariable(value = "id") Long info_activoId,
			@Valid Info_activo info_activoDetails) throws ResourceNotFoundException {
				Info_activo info_activo = info_activoRepository.findById(info_activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Informacion de acivo no existe para este id :: " + info_activoId));


		info_activo.setFecha_movimiento(info_activoDetails.getFecha_movimiento());
		info_activo.setMotivo(info_activoDetails.getMotivo());
		return ResponseEntity.ok(this.info_activoRepository.save(info_activo));
	}


	@DeleteMapping("info_activo/{id}")
	public Map<String, Boolean> deleteInfo_activo(@PathVariable(value = "id") Long info_activoId)
			throws ResourceNotFoundException {
		Info_activo info_activo = info_activoRepository.findById(info_activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Informacion de activo no existe para este id :: " + info_activoId));

		this.info_activoRepository.delete(info_activo);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
