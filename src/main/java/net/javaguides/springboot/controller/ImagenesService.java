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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Activo;
import net.javaguides.springboot.model.Imagenes;
import net.javaguides.springboot.repository.ImagenesRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ImagenesService {

	@Autowired
	private ImagenesRepository imagenesRepository;
	
	@GetMapping("/imagenes")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('PM')")
	public List<Imagenes> getAllActivos(Activo acivo){
		return this.imagenesRepository.findAll();
	}
	
	@GetMapping("/imagenes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Imagenes> getActivoById(@PathVariable(value = "id") Long imagenesId)
			throws ResourceNotFoundException {
		Imagenes imagenes = imagenesRepository.findById(imagenesId)
				.orElseThrow(() -> new ResourceNotFoundException("Activo no existe para este id :: " + imagenesId));
		return ResponseEntity.ok().body(imagenes);
	}
	
	@PostMapping("/imagenes/upload")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, Imagenes imagenes){
		Map<String, Object> response = new HashMap<>();
		
		
		
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
			
			imagenes.setUrl(nombreArchivo);
			imagenesRepository.save(imagenes);
			
			response.put("activo", imagenes);
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
	
	@DeleteMapping("/imagenes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Map<String, Boolean> deleteImagenes(@PathVariable(value = "id") Long imagenesId)
			throws ResourceNotFoundException {
		Imagenes imagenes = imagenesRepository.findById(imagenesId)
				.orElseThrow(() -> new ResourceNotFoundException("La imagen no existe para este id :: " + imagenesId));
		
		String nombreFotoAnterior = imagenes.getUrl();
		if(nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
			}
		}
		
		this.imagenesRepository.delete(imagenes);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
