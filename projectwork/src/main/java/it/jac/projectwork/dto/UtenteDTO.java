package it.jac.projectwork.dto;

import org.springframework.beans.BeanUtils;

import it.jac.projectwork.entity.Utente;

import lombok.Data;

@Data

public class UtenteDTO {
	
	private int idopera;
	
	private String username;
	
	private String password;
	
	private String email;
	
	public static UtenteDTO build(Utente utente) {

		UtenteDTO result = new UtenteDTO();
		BeanUtils.copyProperties(utente, result);

		return result;
	}
	

}