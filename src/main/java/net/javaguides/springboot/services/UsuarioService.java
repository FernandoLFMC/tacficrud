package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	

}
