package it.jac.projectwork.dto;

import javax.persistence.Column;

import org.springframework.beans.BeanUtils;

import it.jac.projectwork.entity.UtenteHasOpera;

import lombok.Data;

@Data

public class UtenteHasOperaDTO {
	
	private int id;
	
	private int idutente;
	
	private int idopera;
	
	private int valore;
	
	public static UtenteHasOperaDTO build(UtenteHasOpera utenteHasOpera) {

		UtenteHasOperaDTO result = new UtenteHasOperaDTO();
		BeanUtils.copyProperties(utenteHasOpera, result);

		return result;
	}
	
	
	

}
