package it.jac.projectwork.dto;

import java.util.Date;

import javax.persistence.Column;

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
	
	private Date creazione;
	
	private Date scadenza;
	
	private int scaduto;
	
	public static OperaDTO build(Opera opera) {

		OperaDTO result = new OperaDTO();
		BeanUtils.copyProperties(opera, result);

		return result;
	}
	

}