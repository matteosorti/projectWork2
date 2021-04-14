package it.jac.projectwork.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.projectwork.dao.UtenteRepository;
import it.jac.projectwork.dto.UtenteDTO;
import it.jac.projectwork.dto.Response;
import it.jac.projectwork.entity.Utente;

@Service
public class UtenteService {
	
	@Autowired
	UtenteRepository utenteRepository;
	
	final static String error = "Nessun utente trovato.";
	
	// create
	
		public Response<Utente> createUtente(Utente utente) {

			Response<Utente> response = new Response<Utente>();

			try {
				this.utenteRepository.save(utente); 

				response.setResult(utente);
				response.setResultTest(true);

			} catch (Exception e) {
				e.getStackTrace();
				response.setError("utente non creato");

			}

			return response;

		}

		// delete
		public Response<String> deleteUtenteById(int id) {

			Response<String> response = new Response<String>();

			try {
				this.utenteRepository.deleteById(id);

				response.setResult("utente eliminato.");
				response.setResultTest(true);

			} catch (Exception e) {
				response.setError("utente non eliminato correttamente.");
			}
			return response;
		}

		// findAll
		public Response<List<UtenteDTO>> findAllUtenti() {

			Response<List<UtenteDTO>> response = new Response<List<UtenteDTO>>();

			List<UtenteDTO> result = new ArrayList<>();

			try {

				Iterator<Utente> iterator = this.utenteRepository.findAll().iterator();

				while (iterator.hasNext()) {

					Utente utente = iterator.next();
					result.add(UtenteDTO.build(utente));

				}

				response.setResult(result);
				response.setResultTest(true);

			} catch (Exception e) {

				response.setError(error);

			}

			return response;

		}

		//find opera by id
		public Response<UtenteDTO> findUtenteById(int id) {

			Response<UtenteDTO> response = new Response<UtenteDTO>();

			try {

				Utente utente = this.utenteRepository.findById(id).get();

				response.setResult(UtenteDTO.build(utente));
				response.setResultTest(true);

			} catch (Exception e) {

				response.setError(error);

			}

			return response;

		}

		//update opera
		public Response<UtenteDTO> updateUtente(Utente utente) {

			Response<UtenteDTO> response = new Response<UtenteDTO>();
			try {
				Utente u = this.utenteRepository.findById(utente.getIdutente()).get();

				if (utente.getUsername() != null)
					u.setUsername(utente.getUsername());
				
				if (utente.getPassword() != null)
					u.setPassword(utente.getPassword());

				if (utente.getEmail() != null)
					u.setEmail(utente.getEmail());	
				
				
				this.utenteRepository.save(u);
				
				response.setResult(UtenteDTO.build(u));
				response.setResultTest(true);

			} catch (Exception e) {
				
				response.setError(error);
				
			}	

			return response;
		}
		
		
		//login
		public Response<UtenteDTO> login(String username, String password) {
			Response<UtenteDTO> response = new Response<UtenteDTO>();
			try {
				Utente user = this.utenteRepository.findByUsername(username);
				if(user.getPassword().equals(password)) {
					response.setResult(UtenteDTO.build(user));
					response.setResultTest(true);
				}
			}catch(Exception e) {
				response.setError(error);
			}
			System.out.println(response);
			return response;
		}


}
