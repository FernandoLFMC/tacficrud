package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Funcionario;
import net.javaguides.springboot.repository.FuncionarioRepository;

@RestController
@RequestMapping("/api/v1/")
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("funcionario")
	public List<Funcionario> getAllFuncionarios(){
		return this.funcionarioRepository.findAll();
	}

}
