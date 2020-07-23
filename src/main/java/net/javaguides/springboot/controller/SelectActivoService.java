package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.SelectActivo;
import net.javaguides.springboot.repository.ActivoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class SelectActivoService {
	
	@Autowired
	private ActivoRepository activoRepository;
	
    @GetMapping("getinfo")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<SelectActivo> getJoinInformation(){
        return activoRepository.getJoinInformation();
    }
    
    @GetMapping("etiqueta")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<SelectActivo> getSelect(){
        return activoRepository.getSelect();
    }
    
    @GetMapping("id_activo")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<SelectActivo> getIdActivo(){
        return activoRepository.getIdActivo();
    }
    
}
