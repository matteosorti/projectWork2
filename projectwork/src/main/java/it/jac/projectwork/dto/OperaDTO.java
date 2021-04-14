package it.jac.projectwork.dto;

import org.springframework.beans.BeanUtils;

import it.jac.projectwork.entity.Opera;

import lombok.Data;

@Data

public class OperaDTO {
	
	private int idopera;
	
	private String titolo;
	
	private String tipologia;
	
	private String descrizione;
	
	private String foto;
	
	private int idartista;
	
	private double valore;
	
	public static OperaDTO build(Opera opera) {

		OperaDTO result = new OperaDTO();
		BeanUtils.copyProperties(opera, result);

		return result;
	}
	

}