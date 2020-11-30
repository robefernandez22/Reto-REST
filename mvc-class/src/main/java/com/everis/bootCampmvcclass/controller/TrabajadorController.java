package com.everis.bootCampmvcclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.everis.bootCampmvcclass.model.Trabajador;
import com.everis.bootCampmvcclass.service.TrabajadorService;

@RestController
@RequestMapping(value = "/trabajadores")
public class TrabajadorController {
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	/**
	 * Métodos correspondientes al reto
	 */
	@GetMapping("/segundoApellidoInformado")
	public ResponseEntity<List<Trabajador>> segundoApellidoInformado() {
		return new ResponseEntity<>(trabajadorService.findBySegundoApellidoInformado(), HttpStatus.OK);
	}
	
	@GetMapping("/segundoApellidoNoInformado")
	public ResponseEntity<List<Trabajador>> segundoApellidoNoInformado() {
		return new ResponseEntity<>(trabajadorService.findBySegundoApellidoNoInformado(), HttpStatus.OK);
	}
	
	@GetMapping("/edades/{edad1}/{edad2}")
	public ResponseEntity<List<Trabajador>> rangoEdades(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2) {
		if (edad2 < edad1) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(trabajadorService.findByRangoEdad(edad1, edad2), HttpStatus.OK);
	}
	
	/**
	 * Métodos correspondientes al taller
	 */
	@GetMapping("/holaMundo")
	public String holaMundo() {
		return "Hola mundo";
	}
	
	@GetMapping("/holaMundo2")
	public ResponseEntity<String> holaMundo2() {
		return new ResponseEntity<>("Hola mundo con ResponseEntity", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Trabajador> createTrabajador(@RequestBody Trabajador t) {
		if (t != null) {
			if (t.getId() != null) {
				return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<>(trabajadorService.create(t), HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Trabajador>> getAll() {
		return new ResponseEntity<>(trabajadorService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		trabajadorService.deleteByid(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public ResponseEntity<Trabajador> updateTrabajador(@RequestBody Trabajador t) {
		if (t != null) {
			if (t.getId() != null) {
				return new ResponseEntity<>(trabajadorService.update(t), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Trabajador> getById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(trabajadorService.findById(id), HttpStatus.OK);
	}

}
