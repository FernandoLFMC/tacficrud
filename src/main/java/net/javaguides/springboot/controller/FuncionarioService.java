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
import net.javaguides.springboot.model.Funcionario;
import net.javaguides.springboot.repository.FuncionarioRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("funcionario")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Funcionario> getAllFuncionarios(){
		return this.funcionarioRepository.findAll();
	}
	
	@GetMapping("funcionario/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable(value = "id") String funcionarioId)
			throws ResourceNotFoundException {
		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("funcionario no existe con este  id :: " + funcionarioId));
		return ResponseEntity.ok().body(funcionario);
	}

	
	@PostMapping("funcionario")
	@PreAuthorize("hasRole('ADMIN')")
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	
	@PutMapping("funcionario/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value = "id") String funcionarioId,
			@Valid @RequestBody Funcionario funcionarioDetails) throws ResourceNotFoundException {
		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario no existe para este  id :: " + funcionarioId));

		funcionario.setCod_seccion(funcionarioDetails.getCod_seccion());
		funcionario.setCargo(funcionarioDetails.getCargo());
		return ResponseEntity.ok(this.funcionarioRepository.save(funcionario));
	}

	//delete employee
	@DeleteMapping("funcionario/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteFuncionario(@PathVariable(value = "id") String funcionarioId)
			throws ResourceNotFoundException {
		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario no existe para este id :: " + funcionarioId));

		this.funcionarioRepository.delete(funcionario);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
