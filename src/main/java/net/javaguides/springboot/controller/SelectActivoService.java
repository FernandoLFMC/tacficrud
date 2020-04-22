package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.SelectActivo;
import net.javaguides.springboot.repository.ActivoRepository;

@RestController
@RequestMapping("/api/v1/")
public class SelectActivoService {
	
	@Autowired
	private ActivoRepository activoRepository;
	
    @GetMapping("getInfo")
    public List<SelectActivo> getJoinInformation(){
        return activoRepository.getJoinInformation();
    }
    
    @GetMapping("getSelect")
    public List<SelectActivo> getSelect(){
        return activoRepository.getSelect();
    }

}
