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
import it.jac.projectwork.entity.Opera;
import it.jac.projectwork.service.OperaService;

@RestController
@RequestMapping("/rest/opera")
public class OperaRestController {
	
	private static Logger log = LoggerFactory.getLogger(OperaRestController.class);
	
	@Autowired
	OperaService operaService;
	
	@GetMapping(path = "/findAll")
	public Response<?> findAllArtisti() {
		
		return operaService.findAllOpere();
		
	}
	
	@GetMapping(path = "/findAllById")
	public Response<?> findAllOpereById(@RequestBody int id) {
		
		return operaService.findOperaById(id);
		
	}
	
	@PostMapping(path ="/create")
	public Response<?> createOpera(@RequestBody Opera opera) {
		
		return operaService.createOpera(opera);
	}
	
	@PostMapping(path ="/delete")
	public Response<?> deleteOpera(@RequestBody int id){
		
		return operaService.deleteOperaById(id);
	}
	
	@PostMapping(path ="/update")
	public Response<?> updateOpera(@RequestBody Opera opera){
		
		return operaService.updateOpera(opera);
	
	}

}
