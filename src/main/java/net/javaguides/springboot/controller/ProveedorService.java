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
import net.javaguides.springboot.model.Proveedor;
import net.javaguides.springboot.repository.ProveedorRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("proveedor")
	public List<Proveedor> getAllProveedors(){
		return this.proveedorRepository.findAll();
	}
	
	
	@GetMapping("proveedor/{id}")
	public ResponseEntity<Proveedor> getProveedorById(@PathVariable(value = "id") Long proveedorId)
			throws ResourceNotFoundException {
		Proveedor proveedor = proveedorRepository.findById(proveedorId)
				.orElseThrow(() -> new ResourceNotFoundException("Proveedor no existe para este  id :: " + proveedorId));
		return ResponseEntity.ok().body(proveedor);
	}

	
	@PostMapping("proveedor")
	public Proveedor createProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	
	@PutMapping("proveedor/{id}")
	public ResponseEntity<Proveedor> updateProveedor(@PathVariable(value = "id") Long proveedorId,
			@Valid Proveedor proveedorDetails) throws ResourceNotFoundException {
		Proveedor proveedor = proveedorRepository.findById(proveedorId)
				.orElseThrow(() -> new ResourceNotFoundException("Proveedor no existe para este id :: " + proveedorId));

		proveedor.setNombre_tienda(proveedorDetails.getNombre_tienda());
		proveedor.setDireccion(proveedorDetails.getDireccion());
		proveedor.setTelefono(proveedorDetails.getTelefono());
		return ResponseEntity.ok(this.proveedorRepository.save(proveedor));
	}


	@DeleteMapping("proveedor/{id}")
	public Map<String, Boolean> deleteProveedor(@PathVariable(value = "id") Long proveedorId)
			throws ResourceNotFoundException {
		Proveedor proveedor= proveedorRepository.findById(proveedorId)
				.orElseThrow(() -> new ResourceNotFoundException("Proveedor no existe para este  id :: " + proveedorId));

		this.proveedorRepository.delete(proveedor);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
