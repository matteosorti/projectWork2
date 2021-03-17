package it.jac.projectwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "opera")
@Data
public class Artista {
	@Id
	@Column(name = "idartista")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idartista;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "corrente")
	private String corrente;
	
	@Column(name = "biografia")
	private String biografia;
}
