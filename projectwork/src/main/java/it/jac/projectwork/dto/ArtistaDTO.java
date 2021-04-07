package it.jac.projectwork.dto;

import org.springframework.beans.BeanUtils;

import it.jac.projectwork.entity.Artista;

import lombok.Data;

@Data

public class ArtistaDTO {
	
	private int idArtista;
	
	private String nome;
	
	private String corrente;
	
	private String biografia;
	
	public static ArtistaDTO build(Artista artista) {

		ArtistaDTO result = new ArtistaDTO();
		BeanUtils.copyProperties(artista, result);

		return result;
	}
	

}
