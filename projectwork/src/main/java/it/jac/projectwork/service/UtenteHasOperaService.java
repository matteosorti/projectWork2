package it.jac.projectwork.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.projectwork.dao.UtenteHasOperaRepository;
import it.jac.projectwork.dto.UtenteHasOperaDTO;
import it.jac.projectwork.dto.Response;
import it.jac.projectwork.entity.UtenteHasOpera;

@Service
public class UtenteHasOperaService {
	
	@Autowired
	UtenteHasOperaRepository utenteHasOperaRepository;
	
	final static String error = "Nessun utentehasopera trovata.";
	
	// create
	
		public Response<UtenteHasOpera> createUtenteHasOpera(UtenteHasOpera utenteHasOpera) {

			Response<UtenteHasOpera> response = new Response<UtenteHasOpera>();

			try {
				this.utenteHasOperaRepository.save(utenteHasOpera); 

				response.setResult(utenteHasOpera);
				response.setResultTest(true);

			} catch (Exception e) {
				e.getStackTrace();
				response.setError("utentehasopera non creata");

			}

			return response;

		}

		// delete
		public Response<String> deleteUtenteHasOperaById(int id) {

			Response<String> response = new Response<String>();

			try {
				this.utenteHasOperaRepository.deleteById(id);

				response.setResult("opera eliminata.");
				response.setResultTest(true);

			} catch (Exception e) {
				response.setError("opera non eliminata correttamente.");
			}
			return response;
		}

		// findAll
		public Response<List<UtenteHasOperaDTO>> findAllUtenteHasOpera() {

			Response<List<UtenteHasOperaDTO>> response = new Response<List<UtenteHasOperaDTO>>();

			List<UtenteHasOperaDTO> result = new ArrayList<>();

			try {

				Iterator<UtenteHasOpera> iterator = this.utenteHasOperaRepository.findAll().iterator();

				while (iterator.hasNext()) {

					UtenteHasOpera utenteHasOpera = iterator.next();
					result.add(UtenteHasOperaDTO.build(utenteHasOpera));

				}

				response.setResult(result);
				response.setResultTest(true);

			} catch (Exception e) {

				response.setError(error);

			}

			return response;

		}

		//find opera by id
		public Response<UtenteHasOperaDTO> findUtenteHasOperaById(int id) {

			Response<UtenteHasOperaDTO> response = new Response<UtenteHasOperaDTO>();

			try {

				UtenteHasOpera utenteHasOpera = this.utenteHasOperaRepository.findById(id).get();

				response.setResult(UtenteHasOperaDTO.build(utenteHasOpera));
				response.setResultTest(true);

			} catch (Exception e) {

				response.setError(error);

			}

			return response;

		}

		//update opera
		public Response<UtenteHasOperaDTO> updateUtenteHasOpera(UtenteHasOpera utenteHasOpera) {

			Response<UtenteHasOperaDTO> response = new Response<UtenteHasOperaDTO>();
			try {
				System.out.println("l'id essere tipo: "+ utenteHasOpera.getId());
				UtenteHasOpera h = this.utenteHasOperaRepository.findById(utenteHasOpera.getId()).get();
					
				
					
				
					if(h.getValore()<utenteHasOpera.getValore()) {
						h.setIdutente(utenteHasOpera.getIdutente());
						h.setIdopera(utenteHasOpera.getIdopera());
						h.setValore(utenteHasOpera.getValore());
					}else {
						response.setError("Offerta bassa");
					}
					
				
				this.utenteHasOperaRepository.save(h);
				
				response.setResult(UtenteHasOperaDTO.build(h));
				response.setResultTest(true);

			} catch (Exception e) {
				
				response.setError(error);
				
			}	

			return response;
		}
		


}

