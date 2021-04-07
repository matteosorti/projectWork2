package it.jac.projectwork.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.projectwork.dao.OperaRepository;
import it.jac.projectwork.dto.OperaDTO;
import it.jac.projectwork.dto.Response;
import it.jac.projectwork.entity.Opera;

@Service
public class OperaService {
	
	@Autowired
	OperaRepository operaRepository;
	
	final static String error = "Nessun opera trovata.";
	
	// create
	
		public Response<Opera> createOpera(Opera opera) {

			Response<Opera> response = new Response<Opera>();

			try {
				this.operaRepository.save(opera); 

				response.setResult(opera);
				response.setResultTest(true);

			} catch (Exception e) {
				e.getStackTrace();
				response.setError("opera non creata");

			}

			return response;

		}

		// delete
		public Response<String> deleteOperaById(int id) {

			Response<String> response = new Response<String>();

			try {
				this.operaRepository.deleteById(id);

				response.setResult("opera eliminata.");
				response.setResultTest(true);

			} catch (Exception e) {
				response.setError("opera non eliminata correttamente.");
			}
			return response;
		}

		// findAll
		public Response<List<OperaDTO>> findAllOpere() {

			Response<List<OperaDTO>> response = new Response<List<OperaDTO>>();

			List<OperaDTO> result = new ArrayList<>();

			try {

				Iterator<Opera> iterator = this.operaRepository.findAll().iterator();

				while (iterator.hasNext()) {

					Opera opera = iterator.next();
					result.add(OperaDTO.build(opera));

				}

				response.setResult(result);
				response.setResultTest(true);

			} catch (Exception e) {

				response.setError(error);

			}

			return response;

		}

		//find opera by id
		public Response<OperaDTO> findOperaById(int id) {

			Response<OperaDTO> response = new Response<OperaDTO>();

			try {

				Opera opera = this.operaRepository.findById(id).get();

				response.setResult(OperaDTO.build(opera));
				response.setResultTest(true);

			} catch (Exception e) {

				response.setError(error);

			}

			return response;

		}

		//update opera
		public Response<OperaDTO> updateOpera(Opera opera) {

			Response<OperaDTO> response = new Response<OperaDTO>();
			try {
				Opera o = this.operaRepository.findById(opera.getIdopera()).get();

				if (opera.getTitolo() != null)
					o.setTitolo(opera.getTitolo());
				
				if (opera.getTipologia() != null)
					o.setTipologia(opera.getTipologia());

				if (opera.getDescrizione() != null)
					o.setDescrizione(opera.getDescrizione());	
				
				if (opera.getIdartista() != 0)
					o.setIdartista(opera.getIdartista());	
				
				if (opera.getValore() != 0)
					o.setValore(opera.getValore());	
				
				if (opera.getFoto() != null)
					o.setFoto(opera.getFoto());		
				
				
				this.operaRepository.save(o);
				
				response.setResult(OperaDTO.build(o));
				response.setResultTest(true);

			} catch (Exception e) {
				
				response.setError(error);
				
			}	

			return response;
		}
		


}
