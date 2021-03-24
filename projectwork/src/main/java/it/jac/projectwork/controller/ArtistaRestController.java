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
import it.jac.projectwork.entity.Artista;
import it.jac.projectwork.service.ArtistaService;

@RestController
@RequestMapping("/rest/artista")
public class ArtistaRestController {
	
	private static Logger log = LoggerFactory.getLogger(ArtistaRestController.class);
	
	@Autowired
	ArtistaService artistaService;
	
	@GetMapping(path = "/findAll")
	public Response<?> findAllArtisti() {
		
		return artistaService.findAllArtisti();
		
	}
	
	@GetMapping(path = "/findAllById")
	public Response<?> findAllArtistiById(@RequestBody int id) {
		
		return artistaService.findAllArtistiById(id);
		
	}
	
	@PostMapping(path ="/create")
	public Response<?> createCustomer(@RequestBody Artista artista) {
		
		return artistaService.createArtista(artista);
	}
	
	@PostMapping(path ="/delete")
	public Response<?> deleteArtista(@RequestBody int id){
		
		return artistaService.deleteArtistaById(id);
	}
	
	@PostMapping(path ="/update")
	public Response<?> updateCustomer(@RequestBody Artista artista){
		
		return artistaService.updateArtista(artista);
	
	}

}
