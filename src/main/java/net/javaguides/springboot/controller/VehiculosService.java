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
import net.javaguides.springboot.model.Vehiculos;
import net.javaguides.springboot.repository.VehiculosRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class VehiculosService {
	
	@Autowired
	private VehiculosRepository vehiculosRepository;
	
	@GetMapping("vehiculos")
	public List<Vehiculos> getAllVehiculos(){
		return this.vehiculosRepository.findAll();
	}
	
	@GetMapping("vehiculos/{id}")
	public ResponseEntity<Vehiculos> getVehiculosById(@PathVariable(value = "id") Long vehiculosId)
			throws ResourceNotFoundException {
		Vehiculos vehiculos = vehiculosRepository.findById(vehiculosId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion. intente nuevamente : : " + vehiculosId));
		return ResponseEntity.ok().body(vehiculos);
	}
	
	@PostMapping("vehiculos")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Vehiculos createVehiculos(@RequestBody Vehiculos vehiculos) {
		return vehiculosRepository.save(vehiculos);
	}

	@PutMapping("vehiculos/{id}")
	public ResponseEntity<Vehiculos> updateVehiculos(@PathVariable(value = "id") Long vehiculosId,
			@Valid @RequestBody Vehiculos vehiculosDetails) throws ResourceNotFoundException {
		Vehiculos vehiculos = vehiculosRepository.findById(vehiculosId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + vehiculosId));
		vehiculos.setColor(vehiculosDetails.getColor());
		vehiculos.setMarca(vehiculosDetails.getMarca());
		vehiculos.setModelo(vehiculosDetails.getModelo());
		vehiculos.setNro_chasis(vehiculosDetails.getNro_chasis());
		vehiculos.setNro_motor(vehiculosDetails.getNro_motor());
		vehiculos.setNro_placa(vehiculosDetails.getNro_placa());
		vehiculos.setProcedencia(vehiculosDetails.getProcedencia());
		vehiculos.setRuat(vehiculosDetails.getRuat());
		vehiculos.setTipo(vehiculosDetails.getTipo());

		
		return ResponseEntity.ok(this.vehiculosRepository.save(vehiculos));
	}

	@DeleteMapping("vehiculos/{id}")
	public Map<String, Boolean> deleteVehiculos(@PathVariable(value = "id") Long vehiculosId)
			throws ResourceNotFoundException {
		Vehiculos vehiculos = vehiculosRepository.findById(vehiculosId)
				.orElseThrow(() -> new ResourceNotFoundException("Seccion no encontrada para esta identificacion : : " + vehiculosId));

		this.vehiculosRepository.delete(vehiculos);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
