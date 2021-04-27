package it.jac.projectwork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.projectwork.dto.Response;
import it.jac.projectwork.entity.UtenteHasOpera;
import it.jac.projectwork.service.UtenteHasOperaService;

@RestController
@RequestMapping("/rest/utenteHasOpera")
public class UtenteHasOperaRestController {
	
	private static Logger log = LoggerFactory.getLogger(UtenteHasOperaRestController.class);
	
	@Autowired
	UtenteHasOperaService utenteHasOperaService;
	
	@GetMapping(path = "/findAll")
	public Response<?> findAllUtenteHasOpera() {
		
		return utenteHasOperaService.findAllUtenteHasOpera();
		
	}
	
	@PostMapping(path = "/findAllById/{id}")
	public Response<?> findAllUtenteHasOperaById(@PathVariable("id") int id) {
		
		return utenteHasOperaService.findUtenteHasOperaById(id);
		
	}
	
	@PostMapping(path ="/create")
	public Response<?> createUtenteHasOpera(@RequestBody UtenteHasOpera utenteHasOpera) {
		
		return utenteHasOperaService.createUtenteHasOpera(utenteHasOpera);
	}
	
	@PostMapping(path ="/delete")
	public Response<?> deleteUtenteHasOpera(@RequestBody int id){
		
		return utenteHasOperaService.deleteUtenteHasOperaById(id);
	}
	
	@PostMapping(path ="/update")
	public Response<?> updateUtenteHasOpera(@RequestBody UtenteHasOpera utenteHasOpera){
		System.out.println(utenteHasOpera);
		return utenteHasOperaService.updateUtenteHasOpera(utenteHasOpera);
	
	}
}
