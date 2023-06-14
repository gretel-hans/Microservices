package com.hans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hans.model.Utente;
import com.hans.service.UtenteService;

@RestController
@RequestMapping("/microservizi/utenti")
public class UtenteController {

	@Autowired UtenteService utenteService;
	
	@GetMapping()
	public ResponseEntity<List<Utente>> trovaTuttiUtenti() {
		return new ResponseEntity<>(utenteService.listaUtenti(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Utente> trovaUtente(@PathVariable Long id) {
		return new ResponseEntity<>(utenteService.trovaUtente(id) ,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Utente> creaUtente(@RequestBody Utente u) {
		return new ResponseEntity<>(utenteService.salvaUtente(u), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> creaUtente(@RequestBody Utente u, @PathVariable Long id) {
		if (id==u.getId()) {
			return new ResponseEntity<>(utenteService.salvaUtente(u), HttpStatus.OK);			
		}else
			return new ResponseEntity<>("ERRORE!! ", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminaUtente(@PathVariable Long id) {
		return new ResponseEntity<>(utenteService.eliminaUtente(id), HttpStatus.OK);
	}
	
}
