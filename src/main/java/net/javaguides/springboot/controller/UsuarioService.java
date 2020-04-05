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
import net.javaguides.springboot.model.Usuario;
import net.javaguides.springboot.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/")
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("usuario")
	public List<Usuario> getAllUsuarios(){
		return this.usuarioRepository.findAll();
	}
	
	
	@GetMapping("usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") String usuarioId)
			throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no existe para este id :: " + usuarioId));
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping("usuario")
	public Usuario createUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
 
	@PutMapping("usuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") String usuarioId,
			@Valid Usuario usuarioDetails) throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no existe para este id :: " + usuarioId));

		usuario.setLogin(usuarioDetails.getLogin());
		usuario.setPwd(usuarioDetails.getPwd());
		usuario.setEstado_ac_inac(usuarioDetails.getEstado_ac_inac());

		return ResponseEntity.ok(this.usuarioRepository.save(usuario));
	}

	
	@DeleteMapping("usuario/{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") String usuarioId)
			throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no existe para este  id :: " + usuarioId));

		this.usuarioRepository.delete(usuario);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	

}
