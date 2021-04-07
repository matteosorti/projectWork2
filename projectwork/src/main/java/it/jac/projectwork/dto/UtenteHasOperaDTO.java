package it.jac.projectwork.dto;

import org.springframework.beans.BeanUtils;

import it.jac.projectwork.entity.UtenteHasOpera;

import lombok.Data;

@Data

public class UtenteHasOperaDTO {
	
	private int id;
	
	private int id_artista;
	
	private int id_opera;
	
	public static UtenteHasOperaDTO build(UtenteHasOpera utenteHasOpera) {

		UtenteHasOperaDTO result = new UtenteHasOperaDTO();
		BeanUtils.copyProperties(utenteHasOpera, result);

		return result;
	}
	
	

}
