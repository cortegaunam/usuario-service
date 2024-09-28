package com.example.usuario_service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario_service.domain.Estado;
import com.example.usuario_service.repository.EstadoRepository;
import com.example.usuario_service.service.EstadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(path="api/estados", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="estado", description="API del Recurso Estado")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	@Operation(summary = "Obtener todos los estados")
	public List<Estado> obtenerEstados() {
		return estadoRepository.findAll();
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Registrar un estado")
	public Estado crearEstado(@RequestBody Estado estado) {
		return estadoRepository.save(estado);
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Obtener un estado por su ID")
	@Parameter(name = "id", description = "ID del estado a obetener", required = true)
	public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable("id") String id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if (estado.isPresent()) {
			return new ResponseEntity<>(estado.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path="{id}", consumes="application/json")
	@Operation(summary = "Actualizar un estado")
	@Parameter(name = "id", description = "ID del estado a actualizar", required = true)
	public ResponseEntity<Estado> actualizarEstado(
			@PathVariable("id") String id, @RequestBody Estado estado) {
		Estado estadoActualizado = estadoService.actualizarEstado(id, estado);
		if (estadoActualizado != null) {
			return new ResponseEntity<>(estadoActualizado, HttpStatus.OK) ;
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Eliminar un estado")
	@Parameter(name = "id", description = "ID del estado a eliminar", required = true)
	public void eliminarEstado(@PathVariable("id") String id) {
		estadoRepository.deleteById(id);
	}

}
