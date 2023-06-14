package com.hans.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/microservizioPrincipale/utenti")
public class MicroserviceController {

	@GetMapping()
	public Object users() {
		RestTemplate rt =new RestTemplate();
		String url ="http://localhost:8081/microservizi/utenti";
		Object response =rt.getForObject(url, Object.class);
		return response;
	}
	
	@GetMapping("/{id}")
	public Object getUser(@PathVariable Long id) {
		RestTemplate rt =new RestTemplate();
		String url ="http://localhost:8081/microservizi/utenti/"+id;
		Object response =rt.getForObject(url, Object.class);
		return response;
	}
	
	@PostMapping()
	public Object createUser(@RequestBody Object o) {
		RestTemplate rt =new RestTemplate();
		String url ="http://localhost:8081/microservizi/utenti";
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestEntity=new HttpEntity<>(o,headers);
		Object response =rt.exchange(url, HttpMethod.POST, requestEntity, Object.class).getBody();
		return response;
	}
	
	@PutMapping("/{id}")
	public Object updateUser(@RequestBody Object o, @PathVariable Long id) {
		RestTemplate rt =new RestTemplate();
		String url ="http://localhost:8081/microservizi/utenti/"+id;
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestEntity=new HttpEntity<>(o,headers);
		Object response =rt.exchange(url, HttpMethod.PUT, requestEntity, Object.class).getBody();
		return response;
	}
	
	@DeleteMapping("/{id}")
	public Object deleteUser(@PathVariable Long id) {
		RestTemplate rt =new RestTemplate();
		String url ="http://localhost:8081/microservizi/utenti/"+id;
		Object response =rt.exchange(url,HttpMethod.DELETE, null,String.class);
		return response;
	}
	
}
