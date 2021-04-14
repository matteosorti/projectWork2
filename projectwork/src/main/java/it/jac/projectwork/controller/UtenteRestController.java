package it.jac.projectwork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.projectwork.dto.Response;
import it.jac.projectwork.entity.Utente;
import it.jac.projectwork.service.UtenteService;

@RestController
@RequestMapping("/rest/utente")
public class UtenteRestController {
	
	private static Logger log = LoggerFactory.getLogger(UtenteRestController.class);
	
	@Autowired
	UtenteService utenteService;
	
	@GetMapping(path = "/findAll")
	public Response<?> findAllUtenti() {
		
		return utenteService.findAllUtenti();
		
	}
	
	@GetMapping(path = "/findAllById")
	public Response<?> findAllUtentiById(@RequestBody int id) {
		
		return utenteService.findUtenteById(id);
		
	}
	
	@PostMapping(path ="/create")
	public Response<?> createUtenti(@RequestBody Utente utente) {
		
		return utenteService.createUtente(utente);
	}
	
	@PostMapping(path ="/delete")
	public Response<?> deleteUtente(@RequestBody int id){
		
		return utenteService.deleteUtenteById(id);
	}
	
	@PostMapping(path ="/update")
	public Response<?> updateUtente(@RequestBody Utente utente){
		
		return utenteService.updateUtente(utente);
	
	}
	
	@PostMapping(path ="/login")
	public Response<?> login(@RequestBody String body){
		log.info("body =" + body);
		
		String username= null;
		String password= null;
		
		int[] array= new int[9];
		int conta=0;
		for(int i=0; i<body.length(); i++) {
			if(body.charAt(i)=='"') {
				array[conta]=i;
				conta++;
			}
		}
		
		username=body.substring(array[2]+1,array[3]);
		password=body.substring(array[6]+1,array[7]);
		
		log.info(username);
		log.info(password);
		return utenteService.login(username, password);
		
	
	}

}

