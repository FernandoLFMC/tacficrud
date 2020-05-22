package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Seccion;
import net.javaguides.springboot.repository.SeccionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class TestRestAPIs {
	
	@Autowired
	private SeccionRepository seccionRepository;
	
	@GetMapping("admin")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Seccion> getAdmin(){
		return this.seccionRepository.findAll();
	}
	
	@GetMapping("user")
	@PreAuthorize("hasRole('USER')")
	public List<Seccion> getUser(){
		return this.seccionRepository.findAll();
	}
	
	@GetMapping("pm")
	@PreAuthorize("hasRole('PM')")
	public List<Seccion> getPm(){
		return this.seccionRepository.findAll();
	}
	
	/*@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String userAccess() {
		return "admin";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER')")
	public String projectManagementAccess() {
		return "user";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM')")
	public String adminAccess() {
		return "pm";
	}*/

}
