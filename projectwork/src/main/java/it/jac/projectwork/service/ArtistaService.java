package it.jac.projectwork.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.projectwork.dao.ArtistaRepository;
import it.jac.projectwork.dto.ArtistaDTO;
import it.jac.projectwork.dto.Response;
import it.jac.projectwork.entity.Artista;

@Service
public class ArtistaService {
	
	@Autowired
	ArtistaRepository artistaRepository;
	
	final static String error = "Nessun artista trovato.";
	
	// create
	
		public Response<Artista> createArtista(Artista artista) {

			Response<Artista> response = new Response<Artista>();

			try {
				this.artistaRepository.save(artista); 

				response.setResult(artista);
				response.setResultTest(true);

			} catch (Exception e) {
				e.getStackTrace();
				response.setError("artista non creato");

			}

			return response;

		}

		// delete
		public Response<String> deleteArtistaById(int id) {

			Response<String> response = new Response<String>();

			try {
				this.artistaRepository.deleteById(id);

				response.setResult("artista eliminato.");
				response.setResultTest(true);

			} catch (Exception e) {
				response.setError("artista non eliminato correttamente.");
			}
			return response;
		}

		// findAll
		public Response<List<ArtistaDTO>> findAllArtisti() {

			Response<List<ArtistaDTO>> response = new Response<List<ArtistaDTO>>();

			List<ArtistaDTO> result = new ArrayList<>();

			try {

				Iterator<Artista> iterator = this.artistaRepository.findAll().iterator();

				while (iterator.hasNext()) {

					Artista artista = iterator.next();
					result.add(ArtistaDTO.build(artista));

				}

				response.setResult(result);
				response.setResultTest(true);

			} catch (Exception e) {

				response.setError(error);

			}

			return response;

		}

		//find customer by id
		public Response<ArtistaDTO> findArtistaById(int id) {

			Response<ArtistaDTO> response = new Response<ArtistaDTO>();

			try {

				Artista artista = this.artistaRepository.findById(id).get();

				response.setResult(ArtistaDTO.build(artista));
				response.setResultTest(true);

			} catch (Exception e) {

				response.setError(error);

			}

			return response;

		}

		//update artista
		public Response<ArtistaDTO> updateArtista(Artista artista) {

			Response<ArtistaDTO> response = new Response<ArtistaDTO>();
			try {
				Artista a = this.artistaRepository.findById(artista.getIdartista()).get();

				if (artista.getNome() != null)
					a.setNome(artista.getNome());
				
				if (artista.getCorrente() != null)
					a.setCorrente(artista.getCorrente());

				if (artista.getBiografia() != null)
					a.setBiografia(artista.getBiografia());	
				
				
				this.artistaRepository.save(a);
				
				response.setResult(ArtistaDTO.build(a));
				response.setResultTest(true);

			} catch (Exception e) {
				
				response.setError(error);
				
			}	

			return response;
		}
		


}
