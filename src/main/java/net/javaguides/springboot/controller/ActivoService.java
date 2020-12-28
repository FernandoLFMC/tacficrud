package net.javaguides.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Activo;
import net.javaguides.springboot.repository.ActivoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ActivoService {
	
	@Autowired
	private ActivoRepository activoRepository;

	

	
	@GetMapping("/activo")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('PM')")
	public List<Activo> getAllActivos(Activo acivo){
		return this.activoRepository.findAll();
	}

	@GetMapping("/activo/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Activo> getActivoById(@PathVariable(value = "id") Long activoId)
			throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));
		return ResponseEntity.ok().body(activo);
	}
	

	@PostMapping("/activo")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Activo createActivo( @RequestBody Activo activo) {
		return activoRepository.save(activo);
	}

 
	@PutMapping("/activo/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Activo> updateActivo(@PathVariable(value = "id") Long activoId,
			@Valid @RequestBody Activo activoDetails) throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));


		activo.setId_cuenta(activoDetails.getId_cuenta());
		activo.setCod_tipo(activoDetails.getCod_tipo());
		activo.setCod_seccion(activoDetails.getCod_seccion());
		activo.setId_funcionario(activoDetails.getId_funcionario());
		activo.setNombre_tipo(activoDetails.getNombre_tipo());
		activo.setDescripcion(activoDetails.getDescripcion());
		activo.setUnidad(activoDetails.getUnidad());
		activo.setEstado_op_nop(activoDetails.getEstado_op_nop());
		activo.setObservacion(activoDetails.getObservacion());
		activo.setVida_util(activoDetails.getVida_util());
		activo.setSujeto_depreciacion(activoDetails.getSujeto_depreciacion());
		return ResponseEntity.ok(this.activoRepository.save(activo));
	}
	
	@PutMapping("/infoactivo/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Activo> infoActivo(@PathVariable(value = "id") Long activoId,
			@Valid @RequestBody Activo activoDetails) throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));


		activo.setCod_seccion(activoDetails.getCod_seccion());
		activo.setId_funcionario(activoDetails.getId_funcionario());
		
		return ResponseEntity.ok(this.activoRepository.save(activo));
	}

	@DeleteMapping("/activo/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Map<String, Boolean> deleteActivo(@PathVariable(value = "id") Long activoId)
			throws ResourceNotFoundException {
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));
		
		String nombreFotoAnterior = activo.getImagen();
		if(nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
			}
		}
		
		this.activoRepository.delete(activo);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/activo/upload")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long activoId) throws ResourceNotFoundException {
		Map<String, Object> response = new HashMap<>();
		
		Activo activo = activoRepository.findById(activoId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + activoId));
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = UUID.randomUUID().toString() + "_" +archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen "+ nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	
			String nombreFotoAnterior = activo.getImagen();
			if(nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
			}
			
			activo.setImagen(nombreArchivo);
			activoRepository.save(activo);
			
			response.put("activo", activo);
			response.put("mensaje", "Has subido correctamente la imagen "+ nombreArchivo);
			
			
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		Resource recurso= null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cragar la imagen: " + nombreFoto);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}

}
