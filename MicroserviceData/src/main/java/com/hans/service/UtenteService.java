package com.hans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.model.Utente;
import com.hans.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired UtenteRepository db;
	
	public Utente salvaUtente(Utente u) {
		return db.save(u);
	}
	
	public Utente trovaUtente(Long id) {
		return db.findById(id).get();
	}
	
	public List<Utente> listaUtenti(){
		return db.findAll();
	}
	
	public String eliminaUtente(Long id) {
		db.deleteById(id);
		return "Utente con id: "+id+" eliminato dal DB!";
	}
	
	
}
